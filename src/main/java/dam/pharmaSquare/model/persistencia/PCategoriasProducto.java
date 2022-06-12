package dam.pharmaSquare.model.persistencia;

/**
 * Representación de la conexión entre productos y categorías en la base de datos.
 *
 * @author Jorge Re - Jkutkut
 */
public class PCategoriasProducto {
    public static final String ID_PRODUCTO = "ID_PRODUCTO";
    public static final String ID_CATEGORIA = "ID_CATEGORIA";

    public static final String[] PK = {ID_PRODUCTO, ID_CATEGORIA};
    public static final String TABLE_NAME = "CATEGORIAS_PRODUCTO";
}
