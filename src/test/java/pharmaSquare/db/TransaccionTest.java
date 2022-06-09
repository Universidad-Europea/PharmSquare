package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.Transaccion;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransaccionTest {
    private static PharmaSquareDB db;

    private static final Object[][] tests = {
        {"123456789A", null, true},
        {null, "Paracetamol", true},
        {"123456789A", "Paracetamol", true},
        {"123456789A", "hola", true},
        {"123456789N", "Paracetamol", true},
        {null, null, true},
        {null, null, false}
    };

    @BeforeClass
    public static void setUpBeforeClass() {
        db = new PharmaSquareDB();
    }


    @Test
    public void getPersonalTest() {
        for (Object[] r : tests) {
            System.out.println("--------------------------");
            System.out.println("--------------------------");
            System.out.println("-----                -----");
            printTransacciones(db.getTransacciones((String) r[0], (String) r[1], (boolean) r[2]));
            System.out.println("-----                -----");
            System.out.println("--------------------------");
            System.out.println("--------------------------");
        }
    }

    // TOOLS
    private static void printTransacciones(ArrayList<Transaccion> personal) {
        for (Transaccion t : personal) {
            System.out.println(t);
        }
    }
}
