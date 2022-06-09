package dam.pharmaSquare.model.persistencia;

/**
 * Representación del personal en la base de datos.
 */
public class PPersonal {
    public static final String DNI = "DNI";
    public static final String NOMBRE = "NOMBRE";
    public static final String CATEGORIA = "CATEGORIA";
    public static final String PASSWD = "PASSWD";

    public static final String PK = DNI;
    public static final String TABLE_NAME = "PERSONAL";

    public static final String[] CATEGORIAS_CHK = {"EMPLEADO", "ADMINISTRADOR"};
}
