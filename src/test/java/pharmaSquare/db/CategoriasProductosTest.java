package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.CategoriaProducto;
import dam.pharmaSquare.model.CategoriasProductos;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class CategoriasProductosTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }

    @Test
    public void getTest() {
        ArrayList<CategoriasProductos> pcs = db.getProductosCategorias();

        for (CategoriasProductos pc : pcs) {
            System.out.println("----------------------------------");
            System.out.println(pc.getProducto());
            for (CategoriaProducto c : pc.getCategorias())
                System.out.println(c);
            System.out.println("----------------------------------");
        }
    }
}
