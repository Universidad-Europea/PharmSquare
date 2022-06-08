package pharmaSquare.db;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;

import dam.pharmaSquare.model.persistencia.PPersonal;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PersonalTest {
    private static PharmaSquareDB db;

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }


    @Test
    public void getPersonalTest() {
        for (String type : PharmaSquareDB.PERSONAL_FILTERS) {
            System.out.println("--------------------------");
            System.out.println(type);
            printPersonal(db.getPersonal(type, "U"));
            System.out.println("--------------------------");
        }
    }

    @Test
    public void getPersonalByNameTest() {
        Personal p = db.getPersonalbyName("Empleado generico uno");
        Personal p2 = db.getPersonalbyName("fasdfasdfasd");

        assertNotNull(p);
        assertNull(p2);
    }

    @Test
    public void addPersonal() {
        db.addPersonal(new Personal(
                "32213243N",
                "Jose Maria",
                PPersonal.CATEGORIAS_CHK[0],
                "estoEsUnaPassword123$"
        ));
    }

    @Test
    public void chkPasswd() {
         assertTrue(db.validPasswdPersonal("123456789E", "aBc23!@"));
         assertFalse(db.validPasswdPersonal("Maria", "root"));
         assertFalse(db.validPasswdPersonal("root", "root"));
    }

    // TOOLS
    private static void printPersonal(ArrayList<Personal> personal) {
        for (Personal p : personal) {
            System.out.println(p.getNombre() + "   es     " + p.getCategoria());
        }
    }
}
