package pharmaSquare.db;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;

import dam.pharmaSquare.model.persistencia.PPersonal;
import dam.pharmaSquare.model.persistencia.PProducto;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ProductoTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }


    @Test
    public void getProductosTest() {
        System.out.println("-----------------------------------------");
        printProducto(db.getProductos(true));
        System.out.println("-----------------------------------------");
        printProducto(db.getProductos(false));
        System.out.println("-----------------------------------------");
    }

    @Test
    public void addProductoTest() {
        Producto p = new Producto(
            "esta es la utilidad que tiene el producto.",
            "Nombre producto",
            "Labs SL",
            23.43,
            23,
            "res/img/foto.png",
            "S"
        );

        db.addProducto(p);
    }

    @Test
    public void modProductosID() {
        ArrayList<Producto> lst = db.getProductos(true);

        Producto p = lst.get(0);

        Producto t = new Producto(
                p.getId(),
                "Esta utilidad no es nada util.",
                "Manolo lopez",
                "laboratorio test",
                32.43,
                42,
                "hola/dev/null",
                "N"
        );

        db.modProducto(t);

        lst = db.getProductos(true);

        Producto p2 = lst.get(0);

        assertEquals(p2.getNombre(), t.getNombre());
        assertEquals(p2.getUtilidad(), t.getUtilidad());
        assertEquals(p2.getLaboratorio(), t.getLaboratorio());
        assertEquals(p2.getPrecio(), t.getPrecio(), 0.01);
        assertEquals(p2.getStock(), t.getStock());
        assertEquals(p2.getFoto(), t.getFoto());
        assertEquals(p2.getNecesitaLogin(), t.getNecesitaLogin());

        assertNotEquals(p2.getNombre(), p.getNombre());
        assertNotEquals(p2.getUtilidad(), p.getUtilidad());
        assertNotEquals(p2.getLaboratorio(), p.getLaboratorio());
        assertNotEquals(p2.getPrecio(), p.getPrecio(), 0.01);
        assertNotEquals(p2.getStock(), p.getStock());
        assertNotEquals(p2.getFoto(), p.getFoto());
        assertNotEquals(p2.getNecesitaLogin(), p.getNecesitaLogin());
    }

    @Test
    public void modProductosNombre() {
        ArrayList<Producto> lst = db.getProductos(true);

        Producto p = lst.get(3);

        Producto t = new Producto(
                // no id => invalid id
                "Esta utilidad no es nada util.",
                p.getNombre(),
                "laboratorio test",
                32.43,
                42,
                "hola/dev/null",
                "N"
        );

        db.modProducto(t);

        lst = db.getProductos(true);

        Producto p2 = lst.get(3);

        assertEquals(p2.getNombre(), t.getNombre());
        assertEquals(p2.getUtilidad(), t.getUtilidad());
        assertEquals(p2.getLaboratorio(), t.getLaboratorio());
        assertEquals(p2.getPrecio(), t.getPrecio(), 0.01);
        assertEquals(p2.getStock(), t.getStock());
        assertEquals(p2.getFoto(), t.getFoto());
        assertEquals(p2.getNecesitaLogin(), t.getNecesitaLogin());


        assertEquals(p2.getId(), p.getId());
        assertEquals(p2.getNombre(), p.getNombre());
        assertNotEquals(p2.getUtilidad(), p.getUtilidad());
        assertNotEquals(p2.getLaboratorio(), p.getLaboratorio());
        assertNotEquals(p2.getPrecio(), p.getPrecio(), 0.01);
        assertNotEquals(p2.getStock(), p.getStock());
        assertNotEquals(p2.getFoto(), p.getFoto());
        assertNotEquals(p2.getNecesitaLogin(), p.getNecesitaLogin());
    }

    @Test
    public void delProducto() {
        assertThrows(InvalidDataException.class, () -> {db.delProducto("");});
        assertThrows(InvalidDataException.class, () -> {db.delProducto(null);});

        db.delProducto("Tiritas");
    }

    // TOOLS
    private static void printProducto(ArrayList<Producto> personal) {
        for (Producto p : personal) {
            System.out.println(p);
        }
    }
}
