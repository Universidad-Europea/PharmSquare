package pharmaSquare.db;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.Transaccion;
import dam.pharmaSquare.model.persistencia.PCliente;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Serie de tests para verificar el correcto fucionamiento de las Transacciones en la base de datos.
 *
 * @author Jorge Re - Jkutkut
 */
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
    public void getTransaccionesTest() {
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

    @Test
    public void addTransaccion() {
        db.addTransaccion(new Transaccion(
            "123456789A",
            2,
            "2021-12-12",
            6
        ));
    }

    // TOOLS
    private static void printTransacciones(ArrayList<Transaccion> personal) {
        for (Transaccion t : personal) {
            System.out.println(t);
        }
    }
}
