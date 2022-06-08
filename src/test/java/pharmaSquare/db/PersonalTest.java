package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;

import dam.pharmaSquare.model.persistencia.PPersonal;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
            printPersonal(db.getPersonal(type));
            System.out.println("--------------------------");
        }
    }

    @Test
    public void addPersonal() {
//        db.addPersonal(new Personal(
//                "32213243N",
//                "Jose Maria",
//                PPersonal.CATEGORIAS_CHK[0],
//                "estoEsUnaPassword123$"
//        ));
    }

    @Test
    public void chkPasswd() {
        assertTrue(db.validPasswdPersonal("Maria", "seguro1234"));
        assertFalse(db.validPasswdPersonal("root", "root"));
    }

    // TOOLS
    private static void printPersonal(ArrayList<Personal> personal) {
        for (Personal p : personal) {
            System.out.println(p.getNombre() + "   es     " + p.getCategoria());
        }
    }
}
