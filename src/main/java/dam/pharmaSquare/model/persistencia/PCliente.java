package dam.pharmaSquare.model.persistencia;

/**
 * Representación de un cliente en la base de datos.
 */
public class PCliente {
    public static final String DNI = "DNI";
    public static final String NOMBRE = "NOMBRE";
    public static final String F_ALTA = "FECHA_ALTA";
    public static final String DIRECCION = "DIRECCION";
    public static final String NACIMIENTO = "NACIMIENTO";
    public static final String PASSWD = "PASSWD";
    public static final String SEXO = "SEXO";
    public static final String TELEFONO = "TELELEFONO";
    public static final String MAIL = "MAIL";

    public static final String PK = DNI;
    public static final String TABLE_NAME = "CLIENTE";

    public static final String[] SEXO_CHK = {"H", "M", "O"};
}
