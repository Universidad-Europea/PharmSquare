package pharmaSquare.model;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Transaccion;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Serie de tests para verificar el correcto fucionamiento del modelo Transacción.
 *
 * @author Jorge Re - Jkutkut
 */
public class TransaccionTest {
    private static Transaccion o;

    @BeforeClass
    public static void setUpBeforeClass() {
        o = new Transaccion(
                "32213243N",
                1,
                "2003-02-02",
                10
        );
    }

    @Test
    public void modDNI() {
        assertThrows(InvalidDataException.class, () -> {o.setDni(null);});
        assertThrows(InvalidDataException.class, () -> {o.setDni("");});
        assertThrows(InvalidDataException.class, () -> {o.setDni("123123123");});
        o.setDni("321321321H");
    }

    @Test
    public void modId() {
        assertThrows(InvalidDataException.class, () -> {o.setIdProducto(-1);});
        assertThrows(InvalidDataException.class, () -> {o.setIdProducto(0);});
        o.setIdProducto(10);
        o.setIdProducto(12121);
    }

    @Test
    public void modFecha() {
        assertThrows(InvalidDataException.class, () -> {o.setFecha(null);});
        assertThrows(InvalidDataException.class, () -> {o.setFecha("");});
        assertThrows(InvalidDataException.class, () -> {o.setFecha("123123123");});
        o.setFecha("2000-02-21");
    }

    @Test
    public void modCantidad() {
        assertThrows(InvalidDataException.class, () -> {o.setCantidad(-1);});
        assertThrows(InvalidDataException.class, () -> {o.setCantidad(0);});
        o.setCantidad(1);
        o.setCantidad(10);
        o.setCantidad(120);
    }
}
