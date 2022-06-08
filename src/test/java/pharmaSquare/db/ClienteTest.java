package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;
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
        assertTrue(db.validPasswdCliente("Juan", "12ab34!!"));
        assertFalse(db.validPasswdCliente("Juan", "casa"));
        assertFalse(db.validPasswdCliente("root", "root"));
    }
}
