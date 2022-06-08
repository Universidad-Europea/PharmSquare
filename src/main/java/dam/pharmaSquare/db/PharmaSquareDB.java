package dam.pharmaSquare.db;

import dam.dataValidation.DataValidation;
import dam.db.AccessDB;
import dam.db.SQLiteQuery;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.Producto;
import dam.pharmaSquare.model.persistencia.PCliente;
import dam.pharmaSquare.model.persistencia.PPersonal;
import dam.pharmaSquare.model.persistencia.PProducto;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PharmaSquareDB extends AccessDB {
    private static final String FILE_PATH = "pharmaSquareDB.properties";

    /**
     * Criterios de ordenación que pueden tener los empleados en el menu VCheckPersonal
     */
    public static final String[] PERSONAL_FILTERS = {"A-Z", "Z-A", "EMPLEADO", "ADMINISTRATIVO"};

    public PharmaSquareDB() {
        super(FILE_PATH);
    }

    // GET

    /**
     * Función que permite obtener una lista de personal siguiendo el criterio definido por PERSONAL_FILTERS
     * @param type Filtro a aplicar.
     * @return ArrayList con todos los empleados requeridos.
     * @throws InvalidDataException si el typo no está en el array.
     */
    public ArrayList<Personal> getPersonal(String type) throws InvalidDataException {
        /**
         * Restricciones que aplicar según el tipo de selección indicado.
         * Los valores ya están definidos ya que este paso no genera una inyección de SQL.
         */
        final String[] RESTRICTIONS = {
                String.format("ORDER BY %s ASC;", PPersonal.NOMBRE),
                String.format("ORDER BY %s DESC;", PPersonal.NOMBRE),
                String.format("WHERE %s = '%s';", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[0]),
                String.format("WHERE %s = '%s';", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[1])
        };

        if (!DataValidation.isStringIn(type, PERSONAL_FILTERS))
            throw new InvalidDataException("El criterio de búsqueda elegido no es conocido.");

        int index;
        for (index = 0; index < PERSONAL_FILTERS.length; index++)
            if (PERSONAL_FILTERS[index].equals(type))
                break;

        String query = String.format(
          "SELECT * FROM %s %s",
            PPersonal.TABLE_NAME,
            RESTRICTIONS[index]
        );

        return sqlite2personal(SQLiteQuery.get(this, 4, query));
    }

    /**
     * Función que permite obtener una lista de productos siguiendo el criterio definido por el argumento.
     * @param necesitaLogin Si el cliente está logeado o no.
     * @return ArrayList con todos los productos requeridos.
     * @throws InvalidDataException si algo falla.
     */
    public ArrayList<Producto> getProductos(boolean necesitaLogin) throws InvalidDataException {
        String filter = "";
        if (!necesitaLogin)
            filter = String.format(
                " WHERE %s = '%s'",
                    PProducto.NECESITA_LOGIN,
                    PProducto.NECESITA_LOGIN_CHK[1]
            );

        String query = String.format(
            "SELECT * FROM %s%s;",
            PProducto.TABLE_NAME,
            filter
        );

        return sqlite2producto(SQLiteQuery.get(this, 8, query));
    }

    /**
     * Verifica si el usuario y la contraseña dadas son válidas.
     * @param table Tabla en uso.
     * @param passwdField Nombre del campo contraseña.
     * @param userField Nombre del campo usuario.
     * @param user Usuario a verificar.
     * @param passwd Password a verificar.
     * @return True si ambos campos son correctos, false en caso contrario.
     */
    private boolean validPasswd(String table, String passwdField, String userField, String user, String passwd) {
        String query = String.format(
            "SELECT %s FROM %s WHERE %s = ?;",
            passwdField,
            table,
            userField
        );

        ArrayList<Object[]> data = SQLiteQuery.get(this, 1, query, user);

        if (data.size() == 0)
            return false;
        return passwd.equals((String) data.get(0)[0]);

    }

    /**
     * Verifica si el usuario y la contraseña dadas son válidas.
     * @param user Nombre del cliente,
     * @param passwd Password del cliente.
     * @return True si ambos campos son correctos, false en caso contrario.
     */
    public boolean validPasswdCliente(String user, String passwd) {
        return validPasswd(
            PCliente.TABLE_NAME,
            PCliente.PASSWD,
            PCliente.MAIL, // hay que coger el mail
            user,
            passwd
        );
    }

    /**
     * Verifica si el usuario y la contraseña dadas son válidas.
     * @param user Nombre del personal,
     * @param passwd Password del personal.
     * @return True si ambos campos son correctos, false en caso contrario.
     */
    public boolean validPasswdPersonal(String user, String passwd) {
        return validPasswd(
                PPersonal.TABLE_NAME,
                PPersonal.PASSWD,
                PPersonal.NOMBRE,
                user,
                passwd
        );
    }

    // ADD

    /**
     * TODO en proceso.
     * @param p
     * @return
     */
    public int addPersonal(Personal p) {
        String query = String.format(
            "INSERT INTO $s (%s, %s, %s, %s) VALUES (?, ?, ?, ?);",
            PPersonal.TABLE_NAME,
            PPersonal.DNI,
            PPersonal.NOMBRE,
            PPersonal.CATEGORIA,
            PPersonal.PASSWD
        );

        return SQLiteQuery.execute(this, query, p.getDni(), p.getNombre(), p.getCategoria(), p.getPasswd());
    }

    /**
     * Añade un cliente a la base de datos.
     * @param c Cliente a añadir.
     * @return Código de resultado de la sentencia SQL
     */
    public int addCliente(Cliente c) {
        String query = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",
                PCliente.TABLE_NAME,
                PCliente.DNI,
                PCliente.NOMBRE,
                PCliente.F_ALTA,
                PCliente.DIRECCION,
                PCliente.NACIMIENTO,
                PCliente.PASSWD,
                PCliente.SEXO,
                PCliente.TELEFONO,
                PCliente.MAIL
        );

        return SQLiteQuery.execute(
        this,
            query,
            c.getDni(),
            c.getNombre(),
            c.getfAlta(),
            c.getDireccion(),
            c.getNacimiento(),
            c.getPasswd(),
            c.getSexo(),
            c.getTelefono(),
            c.getMail()
        );
    }



    // sqlite2model

    private static ArrayList<Personal> sqlite2personal(ArrayList<Object[]> data) {
        ArrayList<Personal> personal = new ArrayList<>();
        Personal p;
        for (Object[] r : data) {
            p = new Personal(
                    (String) r[0], // DNI
                    (String) r[1], // Nombre
                    (String) r[2], // Categoria
                    (String) r[3] // Passwd
            );
            personal.add(p);
        }
        return personal;
    }

    private static ArrayList<Producto> sqlite2producto(ArrayList<Object[]> data) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto p;
        for (Object[] r : data) {
            p = new Producto(
                    (int) r[0], // id
                    (String) r[1], // utilidad
                    (String) r[2], // nombre
                    (String) r[3], // laboratorio
                    (double) r[4], // precio
                    (int) r[5], // stock
                    (String) r[6], // foto
                    (String) r[7] // necesitaLogin
            );
            productos.add(p);
        }
        return productos;
    }

}
