package pharmaSquare.db;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.CategoriaProducto;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThrows;

/**
 * Serie de tests para verificar el correcto fucionamiento de las Categorias de los productos en la base de datos.
 *
 * @author Jorge Re - Jkutkut
 */
public class CategoriaProductoTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }


    @Test
    public void getCategoriaTest() {
        System.out.println("--------------------------");
        printCategorias(db.getCategorias());
        System.out.println("--------------------------");
    }

    @Test
    public void addCategoria() {
        assertThrows(InvalidDataException.class, () -> {db.addCategoria(null);});

        db.addCategoria("Homeopatía");
    }

    @Test
    public void modCategoria() {
        db.modCategoria(new CategoriaProducto(4, "ya no es belleza"));
    }

    // TOOLS
    private static void printCategorias(ArrayList<CategoriaProducto> categorias) {
        for (CategoriaProducto c : categorias) {
            System.out.println(c);
        }
    }
}
