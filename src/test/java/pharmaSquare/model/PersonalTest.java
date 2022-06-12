package pharmaSquare.model;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.CategoriaProducto;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.persistencia.PPersonal;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Serie de tests para verificar el correcto fucionamiento del modelo Personal.
 *
 * @author Jorge Re - Jkutkut
 */
public class PersonalTest {
    private static Personal o;

    @BeforeClass
    public static void setUpBeforeClass() {
        o = new Personal(
            "32213243N",
            "Jose Maria",
            PPersonal.CATEGORIAS_CHK[0],
            "estoEsUnaPassword123$"
        );
    }

    @Test
    public void dniTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    null,
                    "Jose Maria",
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "",
                    "Jose Maria",
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "123123321",
                    "Jose Maria",
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
    }

    @Test
    public void nombreTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    null,
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "",
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "123jlfasdjkfljlk12",
                    PPersonal.CATEGORIAS_CHK[0],
                    "estoEsUnaPassword123$"
            );
        });
    }

    @Test
    public void categoriaTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "pedro",
                    null,
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "pedro",
                    "",
                    "estoEsUnaPassword123$"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "pedro",
                    "fkdjalfadfkl",
                    "estoEsUnaPassword123$"
            );
        });
    }

    @Test
    public void passwdTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "pedro",
                    PPersonal.CATEGORIAS_CHK[0],
                    null
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Personal(
                    "32213243N",
                    "pedro",
                    PPersonal.CATEGORIAS_CHK[0],
                    ""
            );
        });
    }
}
