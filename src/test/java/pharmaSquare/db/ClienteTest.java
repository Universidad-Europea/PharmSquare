package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.persistencia.PCliente;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClienteTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }

    @Test
    public void chkPasswd() {
        assertTrue(db.validPasswdCliente("juan@gmail.com", "12ab34!!"));
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
}
