package dam.pharmaSquare.model.persistencia;

/**
 * Representación de un producto en la base de datos.
 */
public class PProducto {
    public static final String ID = "ID";
    public static final String UTILIDAD = "UTILIDAD";
    public static final String NOMBRE = "NOMBRE";
    public static final String LABORATORIO = "LABORATORIO";
    public static final String PRECIO = "PRECIO";
    public static final String STOCK = "STOCK";
    public static final String FOTO = "FOTO";
    public static final String NECESITA_LOGIN = "NECESITA_LOGIN";

    public static final String PK = ID;
    public static final String TABLE_NAME = "PRODUCTO";

    public static final String[] NECESITA_LOGIN_CHK = {"S", "N"};

    public static final int MIN_UTILIDAD = 10;
    public static final int MAX_UTILIDAD = 200; // TODO verificar con DB que es válido.
}
