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
                "2022-01-01",
                "c/ Luz, 2 Madrid",
                "2000-01-01",
                "holasQWEw231#@",
                PCliente.SEXO_CHK[1],
                "321 321 321",
                "maria@gmail.com"
        ));
    }

    @Test
    public void getCliente() { // No ejecutar directamente, tiene que ser ejecutado sin que se ejecute delClienteTest
        assertThrows(InvalidDataException.class, () -> {db.getCliente("invalidField", "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.DNI, "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.NOMBRE, "ho321a");});

        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.DNI, "12341234R");});
        assertThrows(InvalidDataException.class, () -> {db.getCliente(PCliente.NOMBRE, "estenombrenoesvalido");});

        System.out.println(db.getCliente(PCliente.DNI, "123456789A"));
        System.out.println(db.getCliente(PCliente.NOMBRE, "Juan Garcia"));
        System.out.println(db.getCliente(PCliente.NOMBRE, "juan garcia"));
    }

    @Test
    public void delClienteTest() { // Tiene que ser ejecutado después de addTest
        assertThrows(InvalidDataException.class, () -> {db.delCliente("invalidField", "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.delCliente(PCliente.DNI, "hoa");});
        assertThrows(InvalidDataException.class, () -> {db.delCliente(PCliente.NOMBRE, "ho321a");});

        assertEquals(0, db.delCliente(PCliente.DNI, "12341234R"));
        assertEquals(0, db.delCliente(PCliente.NOMBRE, "estenombrenoesvalido"));

        assertEquals(1, db.delCliente(PCliente.DNI, "123456789A"));
        assertEquals(1, db.delCliente(PCliente.NOMBRE, "Maria"));
    }

   @Test
   public void modCliente() { // No ejecutar directamente, tiene que ser ejecutado sin que se ejecute delClienteTest
        Cliente p = db.getCliente(PCliente.NOMBRE, "Juan Garcia");

        Cliente p2 = new Cliente(
            p.getDni(),
            "Minombre Eseste",
            "1919-01-01",
            "cajlk fadjdf lakdjfkla jdlkf",
            "1919-01-01",
            "fadSF321@",
            PCliente.SEXO_CHK[1],
            "123 12 21 21",
            "holaquetal@gmail.com"
        );

        db.modCliente(p2);

        Cliente p3 = db.getCliente(PCliente.DNI, p.getDni());

       assertEquals(p3.getDni(), p.getDni());
       assertNotEquals(p3.getNombre(), p.getNombre());
       assertNotEquals(p3.getfAlta(), p.getfAlta());
       assertNotEquals(p3.getDireccion(), p.getDireccion());
       assertNotEquals(p3.getNacimiento(), p.getNacimiento());
       assertNotEquals(p3.getPasswd(), p.getPasswd());
       assertNotEquals(p3.getSexo(), p.getSexo());
       assertNotEquals(p3.getTelefono(), p.getTelefono());
       assertNotEquals(p3.getMail(), p.getMail());

       assertEquals(p2.getDni(), p3.getDni());
       assertEquals(p2.getNombre(), p3.getNombre());
       assertEquals(p2.getfAlta(), p3.getfAlta());
       assertEquals(p2.getDireccion(), p3.getDireccion());
       assertEquals(p2.getNacimiento(), p3.getNacimiento());
       assertEquals(p2.getPasswd(), p3.getPasswd());
       assertEquals(p2.getSexo(), p3.getSexo());
       assertEquals(p2.getTelefono(), p3.getTelefono());
       assertEquals(p2.getMail(), p3.getMail());
   }
}
