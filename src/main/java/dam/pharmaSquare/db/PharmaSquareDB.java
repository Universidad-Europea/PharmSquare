package dam.pharmaSquare.db;

import dam.dataValidation.DataValidation;
import dam.db.AccessDB;
import dam.db.SQLiteQuery;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.*;
import dam.pharmaSquare.model.persistencia.*;

import java.util.ArrayList;

/**
 * Clase con todos la lógica necesaria para el uso de la base de datos de la aplicación PharmaSquare.
 *
 * @author Jorge Re - Jkutkut
 */
public class PharmaSquareDB extends AccessDB {
    private static final String FILE_PATH = "pharmaSquareDB.properties";

    /**
     * Criterios de ordenación que pueden tener los empleados en el menu VCheckPersonal
     */
    public static final String[] PERSONAL_FILTERS = {"A-Z", "Z-A", "EMPLEADO", "ADMINISTRATIVO"};
    public static final String[] GENDER = {"FEMENINO", "MASCULINO", "OTROS"};
    public static final String[] DATE = {"MÁS ANTIGUO", "MÁS RECIENTE"};

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
    public Personal getPersonalbyName(String nombre) throws InvalidDataException {
        nombre = nombre.toUpperCase();
        String query = String.format(
                "SELECT * FROM %s WHERE UPPER(%s) = ?;",
                PPersonal.TABLE_NAME,
                PPersonal.NOMBRE
        );
        return sqlite2personal(SQLiteQuery.get(this, 4, query,  nombre));
    }

    /**
     * Obtiene los productos disponibles para el usuario.
     * @param logged Si el usuario está loggeado o no.
     * @return Lista con los productos disponibles.
     * @throws InvalidDataException
     */
    public ArrayList<Producto> getProductos(boolean logged) throws InvalidDataException {
        String filter = "";
        if (!logged)
            filter = String.format(
                " WHERE %s = '%s'",
                    PProducto.NECESITA_LOGIN,
                    PProducto.NECESITA_LOGIN_CHK[1]
            );

        String query = String.format(
            "SELECT %s, %s, %s, %s, %s, %s, %s, %s FROM %s%s;",
            PProducto.ID,
            PProducto.UTILIDAD,
            PProducto.NOMBRE,
            PProducto.LABORATORIO,
            PProducto.PRECIO,
            PProducto.STOCK,
            PProducto.FOTO,
            PProducto.NECESITA_LOGIN,
            PProducto.TABLE_NAME,
            filter
        );
        return sqlite2producto(SQLiteQuery.get(this, 8, query));
    }

    /**
     * Busca todas las transacciones que cumplan estos criterios.
     * @param dni DNI del cliente. Si es null, cualquier cliente.
     * @param producto Nombre del producto. Si null, cualquier producto.
     * @param cronologico Si true, los resultados más antiguos saldrán antes. Else de manera contraria.
     * @return Lista con las transacciones requeridas.
     */
    public ArrayList<Transaccion> getTransacciones(String dni, String producto, boolean cronologico) throws InvalidDataException {
        ArrayList<Object> condValues = new ArrayList<>();
        ArrayList<String> condQuery = new ArrayList<>();

        if (producto != null) {
            condValues.add(producto);
            condQuery.add(String.format(
                ", %s P WHERE P.%s = %s and P.%s = ?",
                PProducto.TABLE_NAME,
                PProducto.PK,
                PTransaccion.ID_PRODUCTO,
                PProducto.NOMBRE
            ));
        }

        if (dni != null) {
            condValues.add(dni);
            condQuery.add(String.format(
                "%s%s = ?",
                (condQuery.size() == 0) ? " WHERE " : "",
                PTransaccion.DNI
            ));
        }

        String query = String.format(
            "SELECT T.* FROM %s T%s ORDER BY %s %s;",
            PTransaccion.TABLE_NAME,
            String.join(" AND ", condQuery),
            PTransaccion.FECHA,
            (cronologico) ? "ASC" : "DESC"
        );

        return sqlite2transaccion(SQLiteQuery.get(this, 4, query, condValues.toArray()));
    }

    /**
     * Obtiene todas las categorías para un producto por orden alfabético.
     * @return Arraylist con las categorias.
     */
    public ArrayList<CategoriaProducto> getCategorias() throws InvalidDataException {
        String query = String.format(
            "SELECT * FROM %s ORDER BY %s ASC;",
            PCategoriaProducto.TABLE_NAME,
            PCategoriaProducto.NOMBRE
        );
        return sqlite2categoria(SQLiteQuery.get(this, 2, query));
    }

    public Cliente getClientebyMail(String mail) throws InvalidDataException {
        mail = mail.toLowerCase();
        String query = String.format(
                "SELECT * FROM %s WHERE %s = ?;",
                PCliente.TABLE_NAME,
                PCliente.MAIL
        );

        ArrayList<Cliente> result = sqlite2cliente(SQLiteQuery.get(this, 9, query, mail));

        if (result.size() == 0)
            throw new InvalidDataException("No se ha encontrado ningún cliente con ese mail.");
        else if (result.size() > 1)
            throw new InvalidDataException("Se ha encontrado más de un cliente con ese mail.");
        else
            return result.get(0);
    }

    /**
     * Obtiene el cliente usando el campo y el valor dado. Si algo no es correcto, una excepción es lanzada.
     * @param field Tiene que ser PCliente.DNI o PCliente.NOMBRE.
     * @param fieldValue El valor que tiene el campo dado. Este tiene que ser válido.
     * @return El cliente solicitado.
     * @throws InvalidDataException Con el mensaje describiendo el error ocasionado.
     */
    public Cliente getCliente(String field, String fieldValue) throws InvalidDataException {
        if (field != PCliente.DNI && field != PCliente.NOMBRE)
            throw new InvalidDataException("El campo field tiene que ser PCliente.DNI o PCliente.NOMBRE");
        // Verificación valor dado
        if (field == PCliente.DNI)
            Cliente.isDniValid(fieldValue);
        else
            Cliente.isNombreValid(fieldValue);

        String query = String.format(
            "SELECT %s, %s, %s, %s, %s, %s, %s, %s, %s FROM %s WHERE UPPER(%s) = UPPER(?)",
                PCliente.DNI,
                PCliente.NOMBRE,
                PCliente.F_ALTA,
                PCliente.DIRECCION,
                PCliente.NACIMIENTO,
                PCliente.PASSWD,
                PCliente.SEXO,
                PCliente.TELEFONO,
                PCliente.MAIL,
                PCliente.TABLE_NAME,
                field
        );
        ArrayList<Cliente> result = sqlite2cliente(SQLiteQuery.get(this, 9, query, fieldValue));

        if (result.size() == 0)
            throw new InvalidDataException(String.format(
                "No se ha encontrado ningún cliente con %s %s",
                field.toLowerCase(),
                fieldValue
            ));

        return result.get(0);
    }

    /**
     * Obtiene todos los productos con sus correspondientes categorías.
     * @return Arraylist con los datos pedidos
     * @throws InvalidDataException Con el mensaje de error si algo falla.
     */
    public ArrayList<CategoriasProductos> getProductosCategorias() throws InvalidDataException {
        String query = String.format(
            "SELECT %s, %s FROM %s ORDER BY %s",
            PCategoriasProducto.ID_PRODUCTO,
            PCategoriasProducto.ID_CATEGORIA,
            PCategoriasProducto.TABLE_NAME,
            PCategoriasProducto.ID_PRODUCTO
        );

        return sqlite2categoriasProductos(SQLiteQuery.get(this, 2, query));
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
    private boolean validPasswd(String table, String passwdField, String userField, String user, String passwd) throws InvalidDataException {
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
     * @param userMail Nombre del cliente,
     * @param passwd Password del cliente.
     * @return True si ambos campos son correctos, false en caso contrario.
     */
    public boolean validPasswdCliente(String userMail, String passwd) throws InvalidDataException {
        return validPasswd(
            PCliente.TABLE_NAME,
            PCliente.PASSWD,
            PCliente.MAIL, // hay que coger el mail
            userMail,
            passwd
        );
    }

    /**
     * Verifica si el usuario y la contraseña dadas son válidas.
     * @param userDni Dni del personal,
     * @param passwd Password del personal.
     * @return True si ambos campos son correctos, false en caso contrario.
     */
    public boolean validPasswdPersonal(String userDni, String passwd) throws InvalidDataException {
        return validPasswd(
                PPersonal.TABLE_NAME,
                PPersonal.PASSWD,
                PPersonal.DNI,
                userDni,
                passwd
        );
    }

    // ADD

    /**
     * Añade un usuario a la base de datos.
     * @param p Personal a añadir.
     * @return Código resultado al ejecutar la secuencia SQL.
     * @throws InvalidDataException si el usuario ya existe o ha habido un error en la base de datos.
     */
    public int addPersonal(Personal p) throws InvalidDataException {
        String query = String.format(
            "INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?);",
            PPersonal.TABLE_NAME,
            PPersonal.DNI,
            PPersonal.NOMBRE,
            PPersonal.CATEGORIA,
            PPersonal.PASSWD
        );

        return SQLiteQuery.execute(this, query, p.getDni(), p.getNombre(), p.getCategoria(), p.getPasswd());
    }

    /**
     * Añade el producto especificado a la base de datos.
     * @param p Producto a añadir.
     * @return Código resultado al ejecutar la sentencia.
     * @throws InvalidDataException Con el mensaje de error de lo que ha salido mal.
     */
    public int addProducto(Producto p) throws InvalidDataException {
        String query = String.format(
            "INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?, ?);",
            PProducto.TABLE_NAME,
            PProducto.UTILIDAD,
            PProducto.NOMBRE,
            PProducto.LABORATORIO,
            PProducto.PRECIO,
            PProducto.STOCK,
            PProducto.FOTO,
            PProducto.NECESITA_LOGIN
        );

        return SQLiteQuery.execute(
        this,
            query,
            p.getUtilidad(),
            p.getNombre(),
            p.getLaboratorio(),
            p.getPrecio(),
            p.getStock(),
            p.getFoto(),
            p.getNecesitaLogin()
        );
    }

    /**
     * Añade un cliente a la base de datos.
     * @param c Cliente a añadir.
     * @return Código de resultado de la sentencia SQL
     * @throws InvalidDataException si el usuario ya existe o ha habido un error en la base de datos.
     */
    public int addCliente(Cliente c) throws InvalidDataException {
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

    /**
     * Añade una nueva categoría a la base de datos.
     * @param categoria Nueva categoría que añadir.
     * @return Resultado al ejecutar la sentencia.
     * @throws InvalidDataException si hay algún error.
     */
    public int addCategoria(String categoria) throws InvalidDataException {
        CategoriaProducto.isNombreValid(categoria);
        String query = String.format(
            "INSERT INTO %s (%s) VALUES (?)",
            PCategoriaProducto.TABLE_NAME,
            PCategoriaProducto.NOMBRE
        );
        return SQLiteQuery.execute(this, query, categoria);
    }

    /**
     * Añade una nueva transación a la base de datos.
     * @param t Nueva transacción a añadir.
     * @return Código resultado de ejecutar la sentencia.
     */
    public int addTransaccion(Transaccion t) {

        ArrayList<Producto> productos = getProductos(true);
        Producto p = null;

        for (Producto pp : productos) {
            if (pp.getId() == t.getIdProducto()) {
                p = pp;
                break;
            }
        }
        if (p == null)
            throw new InvalidDataException("Producto no encontrado.");
        if (t.getCantidad() > p.getStock())
            throw new InvalidDataException("No hay suficiente stock para realizar el pedido.");

        String query = String.format(
            "INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?);",
            PTransaccion.TABLE_NAME,
            PTransaccion.DNI,
            PTransaccion.ID_PRODUCTO,
            PTransaccion.FECHA,
            PTransaccion.CANTIDAD
        );

        int r = SQLiteQuery.execute(
            this,
            query,
            t.getDni(),
            t.getIdProducto(),
            t.getFecha(),
            t.getCantidad()
        );

        p = new Producto(
                p.getId(),
                p.getUtilidad(),
                p.getNombre(),
                p.getLaboratorio(),
                p.getPrecio(),
                p.getStock() - t.getCantidad(),
                p.getFoto(),
                p.getNecesitaLogin()
        );
        modProducto(p);

        return r;
    }

    // MODIFY

    /**
     * Función que modifica el valor de un Personal en función del objeto Personal recibido.
     * @param p Objeto de tipo personal.
     * @return Object Personal.
     */
    public int modPersonal(Personal p) throws InvalidDataException {
        String query = String.format(
                "REPLACE INTO %s VALUES  (?, ?, ?, ?);",
                PPersonal.TABLE_NAME
        );
        return SQLiteQuery.execute(
                this,
                query,
                p.getDni(),
                p.getNombre(),
                p.getCategoria(),
                p.getPasswd()
        );
    }

    /**
     * Modifica el producto dado en la base de datos.
     * <br>
     * Tiene dos maneras de uso:
     * <li>Todos los parámetros correctamente definidos</li>
     *  Utiliza el ID del producto para poder modificar TODOS los demás atributos (incluído el nombre).
     *
     * <li>El ID no está definido</li>
     *  Usa el nombre del producto para poder modificar el resto de atributos. El ID no se modifica al ser PK.
     *
     * @param p producto modificado que actualizar en la base de datos.
     * @return Código resultante el la ejecución SQL.
     */
    public int modProducto(Producto p) throws InvalidDataException {
        String query;
        if (p.getId() != PProducto.INVALID_ID) {
            query = String.format(
                    "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?;",
                    PProducto.TABLE_NAME,
                    PProducto.UTILIDAD,
                    PProducto.NOMBRE,
                    PProducto.LABORATORIO,
                    PProducto.PRECIO,
                    PProducto.STOCK,
                    PProducto.FOTO,
                    PProducto.NECESITA_LOGIN,
                    PProducto.PK // Condición de búsqueda.
            );

            return SQLiteQuery.execute(
                    this,
                    query,
                    p.getUtilidad(),
                    p.getNombre(),
                    p.getLaboratorio(),
                    p.getPrecio(),
                    p.getStock(),
                    p.getFoto(),
                    p.getNecesitaLogin(),
                    p.getId() // Condición de búsqueda.
            );
        }
        else {
            query = String.format(
                    "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?;",
                    PProducto.TABLE_NAME,
                    PProducto.UTILIDAD,
                    PProducto.LABORATORIO,
                    PProducto.PRECIO,
                    PProducto.STOCK,
                    PProducto.FOTO,
                    PProducto.NECESITA_LOGIN,
                    PProducto.NOMBRE // Condición de búsqueda.
            );

            return SQLiteQuery.execute(
                    this,
                    query,
                    p.getUtilidad(),
                    p.getLaboratorio(),
                    p.getPrecio(),
                    p.getStock(),
                    p.getFoto(),
                    p.getNecesitaLogin(),
                    p.getNombre() // Condición de búsqueda.
            );
        }
    }

    /**
     * Modifica los valores del cliente dado. Se pueden modificar todos los campos menos el DNI.
     * @param c Cliente con los valores actualizados.
     * @return Código resultado al realizar la ejecución.
     */
    public int modCliente(Cliente c) throws InvalidDataException {
        String query = String.format(
            "UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",
            PCliente.TABLE_NAME,
            PCliente.NOMBRE,
            PCliente.F_ALTA,
            PCliente.DIRECCION,
            PCliente.NACIMIENTO,
            PCliente.PASSWD,
            PCliente.SEXO,
            PCliente.TELEFONO,
            PCliente.MAIL,
            PCliente.DNI
        );
        return SQLiteQuery.execute(
            this,
            query,
            c.getNombre(),
            c.getfAlta(),
            c.getDireccion(),
            c.getNacimiento(),
            c.getPasswd(),
            c.getSexo(),
            c.getTelefono(),
            c.getMail(),
            c.getDni()
        );
    }

    /**
     * Renombra la categoría introducida por argumento con el nombre dado.
     * @param c Categoría con el nuevo nombre.
     * @return Código resultado de ejutar la secuencia SQL.
     */
    public int modCategoria(CategoriaProducto c) throws InvalidDataException {
        String query = String.format(
            "UPDATE %s SET %s = ? WHERE %s = ?",
            PCategoriaProducto.TABLE_NAME,
            PCategoriaProducto.NOMBRE,
            PCategoriaProducto.PK
        );
        return SQLiteQuery.execute(this, query, c.getNombre(), c.getId());
    }

    // Las transacciones no se pueden modificar por seguridad/integridad de los ingresos.

    // Remove

    /**
     * Intenta borrar un producto.
     * @param nombre nombre del producto.
     * @return Código resultado al ejecutar la sentencia.
     */
    public int delProducto(String nombre) throws InvalidDataException {
        Producto.isNombreValid(nombre);
        String query = String.format(
            "DELETE FROM %s WHERE UPPER(%s) = UPPER(?);",
            PProducto.TABLE_NAME,
            PProducto.NOMBRE
        );
        return (SQLiteQuery.execute(this, query,  nombre));
    }

    /**
     * Borra un cliente de la base de datos.
     * @param field Campo que usar para identificar al cliente. Tiene que ser PCliente.DNI o PCliente.NOMBRE.
     * @param fieldValue Valor del campo especificado.
     * @return Código resultante de borrar el cliente.
     */
    public int delCliente(String field, String fieldValue) throws InvalidDataException {
        if (field != PCliente.DNI && field != PCliente.NOMBRE)
            throw new InvalidDataException("El campo field tiene que ser PCliente.DNI o PCliente.NOMBRE");
        // Verificación valor dado
        if (field == PCliente.DNI)
            Cliente.isDniValid(fieldValue);
        else
            Cliente.isNombreValid(fieldValue);

        String query = String.format(
            "DELETE FROM %s WHERE UPPER(%s) = UPPER(?);",
            PCliente.TABLE_NAME,
            field
        );

        return SQLiteQuery.execute(this, query, fieldValue);
    }

    /**
     * Función que elimina un personal en función del parametro recibido
     * @param nombre Dni del  personal a eliminar
     * @return Object Personal.
     */
    public int delPersonal(String nombre) throws InvalidDataException {
        return delPersonal(PPersonal.NOMBRE, nombre);
    }

    /**
     * Intenta borrar el personal del la base de datos.
     * @param field Campo que usar para identificar al personal. Tiene que ser PPersonal.DNI o PPersonal.NOMBRE.
     * @param fieldValue Valor del campo especificado.
     * @return Código resultante de borrar el personal.
     */
    public int delPersonal(String field, String fieldValue) throws InvalidDataException {
        if (field != PPersonal.DNI && field != PPersonal.NOMBRE)
            throw new InvalidDataException("El campo field tiene que ser PPersonal.DNI o PPersonal.NOMBRE");
        // Verificación valor dado
        if (field == PPersonal.DNI)
            Cliente.isDniValid(fieldValue);
        else
            Cliente.isNombreValid(fieldValue);

        String query = String.format(
                "DELETE FROM %s WHERE UPPER(%s) = UPPER(?);",
                PPersonal.TABLE_NAME,
                field
        );

        return SQLiteQuery.execute(this, query, fieldValue);
    }

    // Las transacciones no se pueden eliminar por motivos de seguridad.

    // sqlite2model: parser between sqlite output and model.

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
        if (data.size() == 0)
            return null;
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
                    (String) r[0], // dni cliente
                    (int) r[1], // producto id
                    (String) r[2], // fecha
                    (int) r[3] // cantidad
            );
            transaccions.add(t);
        }
        return transaccions;
    }

    private static ArrayList<CategoriaProducto> sqlite2categoria(ArrayList<Object[]> data) {
        ArrayList<CategoriaProducto> categorias = new ArrayList<>();
        CategoriaProducto c;
        for (Object[] r : data) {
            c = new CategoriaProducto((int) r[0], (String) r[1]);
            categorias.add(c);
        }
        return categorias;
    }

    private static ArrayList<Cliente> sqlite2cliente(ArrayList<Object[]> data) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente c;
        for (Object[] r : data) {
            c = new Cliente(
                    (String) r[0],
                    (String) r[1],
                    (String) r[2],
                    (String) r[3],
                    (String) r[4],
                    (String) r[5],
                    (String) r[6],
                    (String) r[7],
                    (String) r[8]
            );
            clientes.add(c);
        }
        return clientes;
    }

    private ArrayList<CategoriasProductos> sqlite2categoriasProductos(ArrayList<Object[]> data) {
        ArrayList<Producto> productos = getProductos(true);
        ArrayList<CategoriaProducto> categorias = getCategorias();

        ArrayList<CategoriasProductos> result = new ArrayList<>();

        Object[] r;
        boolean addit;
        for (int i = 0; i < data.size(); i++) {
            r = data.get(i);
            addit = false;
            if (i == 0)
                addit = true;
            else if ((int) r[0] != result.get(result.size() - 1).getProducto().getId())
                addit = true;

            if (addit) {
                for (Producto p : productos) {
                    if (p.getId() == (int) r[0]) {
                        result.add(new CategoriasProductos(p, new ArrayList<CategoriaProducto>()));
                        break;
                    }
                }
            }

            for (CategoriaProducto c : categorias) {
                if (c.getId() == (int) r[1]) {
                    result.get(result.size() - 1).getCategorias().add(c);
                    break;
                }
            }
        }

        return result;
    }
}
