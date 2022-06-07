package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;

import dam.pharmaSquare.model.persistencia.PPersonal;
import org.junit.*;

import java.util.ArrayList;

public class ProductoTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }


    @Test
    public void getPersonalTest() {
        System.out.println("-----------------------------------------");
        printProducto(db.getProductos(true));
        System.out.println("-----------------------------------------");
        printProducto(db.getProductos(false));
        System.out.println("-----------------------------------------");
    }

    // TOOLS
    private static void printProducto(ArrayList<Producto> personal) {
        for (Producto p : personal) {
            System.out.println(p);
        }
    }
}
