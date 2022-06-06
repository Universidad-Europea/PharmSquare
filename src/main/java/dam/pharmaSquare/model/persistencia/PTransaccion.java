package dam.pharmaSquare.model.persistencia;

public class PTransaccion {
    public static final String DNI = "DNI_CLIENTE";
    public static final String ID_PRODUCTO = "PRODUCTO_ID";
    public static final String FECHA = "FECHA";
    public static final String CANTIDAD = "CANTIDAD";

    public static final String[] PK = {DNI, ID_PRODUCTO, FECHA};
    public static final String TABLE_NAME = "TRANSACCION";
}
