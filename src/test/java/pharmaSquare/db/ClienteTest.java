package pharmaSquare.db;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.persistencia.PCliente;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClienteTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }

    @Test
    public void chkPasswd() {
        assertTrue(db.validPasswdCliente("juan@gmail.com", "12a!DSAb34!"));
        assertFalse(db.validPasswdCliente("Juan", "casa"));
        assertFalse(db.validPasswdCliente("root", "root"));
    }

    @Test
    public void addTest() {
        db.addCliente(new Cliente(
                "21212121U",
                "Maria",
                "01/01/2022",
                "c/ Luz, 2 Madrid",
                "01/01/2000",
                "holasQWEw231#@",
                PCliente.SEXO_CHK[1],
                "321 321 321",
                "maria@gmail.com"
        ));
    }

    @Test
    public void getCliente() {
        assertThrows(InvalidDataException.class, () -> {db.getCliente("invalidField", "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.DNI, "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.NOMBRE, "ho321a");});

        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.DNI, "12341234R");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.NOMBRE, "estenombrenoesvalido");});

        System.out.println(db.getCliente(PCliente.DNI, "123456789A"));
        System.out.println(db.getCliente(PCliente.NOMBRE, "Juan Garcia"));
        System.out.println(db.getCliente(PCliente.NOMBRE, "juan garcia"));

    }
}
