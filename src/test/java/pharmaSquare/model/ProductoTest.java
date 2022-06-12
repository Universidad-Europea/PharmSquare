package pharmaSquare.model;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Producto;
import org.junit.*;
import static org.junit.Assert.*;

public class ProductoTest {
    private static Producto o;

    @BeforeClass
    public static void setUpBeforeClass() {
        o = new Producto(
                "esta es la utilidad que tiene el producto.",
                "Nombre producto",
                "Labs SL",
                23.43,
                23,
                "res/img/foto.png",
                "S"
        );
    }

    @Test
    public void idTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    -1,
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void utilidadTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    null,
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "e",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });

        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "ejfklasdjflka jsdklf; jsdal;fj lkasdjfl; asdj fl;ajsd l;fkjasdlk fjalkds jfklasjd klfjasdlkfjl kasdjfkld saj fla jsdklfj adslkfjl kasdjflkd jasklfj asdklfjlk adsjfklasd jklfjasdkl fja kldjfklad jsklf jasdklfjdlaskf jakldsj fkajdlf a",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void nombreTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    null,
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void laboratorioTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    null,
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void precioTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    -1.2,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    0,
                    23,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void stockTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    -10,
                    "res/img/foto.png",
                    "S"
            );
        });
    }

    @Test
    public void fotoTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    null,
                    "S"
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "",
                    "S"
            );
        });
    }

    @Test
    public void necesitaLoginTest() {
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    null
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    ""
            );
        });
        assertThrows(InvalidDataException.class, () -> {
            o = new Producto(
                    "esta es la utilidad que tiene el producto.",
                    "Nombre producto",
                    "Labs SL",
                    23.43,
                    23,
                    "res/img/foto.png",
                    "fadsfasd"
            );
        });
    }
}
