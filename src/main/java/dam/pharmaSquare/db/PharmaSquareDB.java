package dam.pharmaSquare.db;

import dam.dataValidation.DataValidation;
import dam.db.AccessDB;
import dam.db.SQLiteQuery;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.Producto;
import dam.pharmaSquare.model.Transaccion;
import dam.pharmaSquare.model.persistencia.PCliente;
import dam.pharmaSquare.model.persistencia.PPersonal;
import dam.pharmaSquare.model.persistencia.PProducto;

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
     * Función que permite obtener una lista de personal siguiendo el criterio definido por PERSONAL_FILTERS en función
     * de los dos parametros recibidos
     * @param type Filtro a aplicar.
     * @param nombre Nombre del personal a buscar.
     * @return ArrayList con todos los empleados requeridos.
     * @throws InvalidDataException si el typo no está en el array.
     */
    public ArrayList<Personal> getPersonal(String type, String nombre) throws InvalidDataException {
        /**
         * Restricciones que aplicar según el tipo de selección indicado.
         * Los valores ya están definidos ya que este paso no genera una inyección de SQL.
         */
        final String[] RESTRICTIONCOMBOBOX = {
                String.format("WHERE UPPER(%s) LIKE ? ORDER BY %s ASC;", PPersonal.NOMBRE,  PPersonal.NOMBRE),
                String.format("WHERE UPPER(%s) LIKE ? ORDER BY %s DESC;", PPersonal.NOMBRE,  PPersonal.NOMBRE),
                String.format("WHERE %s = '%s' AND UPPER(%s) LIKE ?;", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[0], PPersonal.NOMBRE),
                String.format("WHERE %s = '%s' AND UPPER(%s) LIKE ?;", PPersonal.CATEGORIA, PPersonal.CATEGORIAS_CHK[1], PPersonal.NOMBRE)
        };


        if (!DataValidation.isStringIn(type, PERSONAL_FILTERS))
            throw new InvalidDataException("El criterio de búsqueda elegido no es conocido.");

        int index;
        for (index = 0; index < PERSONAL_FILTERS.length; index++)
            if (PERSONAL_FILTERS[index].equals(type))
                break;
        nombre = nombre.toUpperCase();

        String query = String.format(
          "SELECT * FROM %s %s",
            PPersonal.TABLE_NAME,
            RESTRICTIONCOMBOBOX[index]

        );
        return sqlite2listapersonal(SQLiteQuery.get(this, 4, query, "%" + nombre + "%"));
    }

    /**
     * Función que permite obtener un objeto Personal en función del nombre recibido como parámetro
     * @param nombre Nombre del personal a buscar.
     * @return Object Personal.
     */
    public Personal getPersonalbyName(String nombre) {

        nombre = nombre.toUpperCase();

        String query = String.format(
                "SELECT * FROM %s WHERE UPPER(%s) = ?;",
                PPersonal.TABLE_NAME,
                PPersonal.NOMBRE

        );

        return sqlite2personal(SQLiteQuery.get(this, 4, query,  nombre ));
    }

    /**
     * Función que modifica el valor de un Personal  en función del objeto Personal recibido
     * @param p Objeto de tipo personal
     * @return Object Personal.
     */
    public int modPersonal(Personal p) {
        String nombre = p.getNombre();
        String dni = p.getDni();
        String categoria = p.getCategoria();
        String passwd = p.getPasswd();


        String query = String.format(
                "REPLACE INTO %s VALUES  (?, ?, ?, ?);",
                PPersonal.TABLE_NAME

        );

        return (SQLiteQuery.execute(this, query,  dni, nombre, categoria, passwd));
    }


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

    public ArrayList<Transaccion> getTransacciones(String dni, String Producto, boolean cronologico) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();

        String query = String.format(
            "SELECT * FROM %s;",
            PTransaccion.TABLE_NAME
        );

        return sqlite2transaccion(SQLiteQuery.get(this, 4, query));
    }

    // CHECKERS

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
                PPersonal.DNI,
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

    private static ArrayList<Personal> sqlite2listapersonal(ArrayList<Object[]> data) {
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

    private static Personal sqlite2personal(ArrayList<Object[]> data) {
        System.out.println(data.size());
         Object[] r =  data.get(0);
         Personal p;
            p = new Personal(
                    (String) r[0], // DNI
                    (String) r[1], // Nombre
                    (String) r[2], // Categoria
                    (String) r[3] // Passwd
            );
            

        return p;
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

    private static ArrayList<Transaccion> sqlite2transaccion(ArrayList<Object[]> data) {
        ArrayList<Transaccion> transaccions = new ArrayList<>();
        Transaccion t;
        for (Object[] r : data) {
            t = new Transaccion(
                    (String) r[1], // dni cliente
                    (int) r[2], // producto id
                    (String) r[3], // fecha
                    (double) r[4] // cantidad
            );
            transaccions.add(t);
        }
        return transaccions;
    }

}
