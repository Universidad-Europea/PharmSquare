package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;

import org.junit.*;

import java.util.ArrayList;

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

    private static void printPersonal(ArrayList<Personal> personal) {
        for (Personal p : personal) {
            System.out.println(p.getNombre() + "   es     " + p.getCategoria());
        }
    }
}
