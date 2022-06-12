package pharmaSquare.model;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.CategoriaProducto;
import org.junit.*;
import static org.junit.Assert.*;

public class CategoriaProductoTest {

    private static CategoriaProducto o;

    @BeforeClass
    public static void setUpBeforeClass() {
        o = new CategoriaProducto(
            1,
            "Test Garcia"
        );
    }

    @Test
    public void idTest() {
        assertThrows(InvalidDataException.class, () -> {o = new CategoriaProducto(-1, "hola");});
        assertThrows(InvalidDataException.class, () -> {o = new CategoriaProducto(null, "hola");});
    }

    @Test
    public void nombreTest() {
        assertThrows(InvalidDataException.class, () -> {o = new CategoriaProducto(1, null);});
        assertThrows(InvalidDataException.class, () -> {o = new CategoriaProducto(1, "");});
    }
}
