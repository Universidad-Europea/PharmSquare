package pharmaSquare.model;

import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.persistencia.PCliente;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Serie de tests para verificar el correcto fucionamiento del modelo Cliente.
 *
 * @author Jorge Re - Jkutkut
 */
public class ClienteTest {

    private static Cliente o;

    @BeforeClass
    public static void setUpBeforeClass() {
        o = new Cliente( "123123123R",
            "Test Garcia",
            "2020-01-01",
            "calle de la luz 1",
            "2000-01-01",
            "fjsdklSD12!",
            PCliente.SEXO_CHK[1],
            "922 921 291",
            "mail@mail.com"
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
    public void modNombre() {
        assertThrows(InvalidDataException.class, () -> {o.setNombre(null);});
        assertThrows(InvalidDataException.class, () -> {o.setNombre("");});
        assertThrows(InvalidDataException.class, () -> {o.setNombre("123 13 d2!@");});
        o.setNombre("fjklsdfa fjsda klf");
    }

    @Test
    public void modFAlta() {
        assertThrows(InvalidDataException.class, () -> {o.setFAlta(null);});
        assertThrows(InvalidDataException.class, () -> {o.setFAlta("");});
        assertThrows(InvalidDataException.class, () -> {o.setFAlta("fasdfasdfadfad");});
        o.setFAlta("2022-03-03");
    }

    @Test
    public void modDir() {
        assertThrows(InvalidDataException.class, () -> {o.setDireccion(null);});
        assertThrows(InvalidDataException.class, () -> {o.setDireccion("");});
        o.setDireccion("calle de la calle de la calle.");
    }

    @Test
    public void modNac() {
        assertThrows(InvalidDataException.class, () -> {o.setNacimiento(null);});
        assertThrows(InvalidDataException.class, () -> {o.setNacimiento("");});
        assertThrows(InvalidDataException.class, () -> {o.setNacimiento("fasdfasdfads");});
        o.setNacimiento("2003-01-01");
    }

    @Test
    public void modPass() {
        assertThrows(InvalidDataException.class, () -> {o.setPasswd(null);});
        assertThrows(InvalidDataException.class, () -> {o.setPasswd("");});
//        assertThrows(InvalidDataException.class, () -> {o.setPasswd("fasdfasdfasd");});
        o.setPasswd("fdsSE123!@");
    }

    @Test
    public void modSex() {
        assertThrows(InvalidDataException.class, () -> {o.setSexo(null);});
        assertThrows(InvalidDataException.class, () -> {o.setSexo("");});
        assertThrows(InvalidDataException.class, () -> {o.setSexo("jflakdsjfla");});
        o.setSexo(PCliente.SEXO_CHK[1]);
    }

    @Test
    public void modTel() {
        assertThrows(InvalidDataException.class, () -> {o.setTelefono(null);});
        assertThrows(InvalidDataException.class, () -> {o.setTelefono("");});
        assertThrows(InvalidDataException.class, () -> {o.setTelefono("fasf");});
        o.setTelefono("722 22 22 22");
    }

    @Test
    public void modMail() {
        assertThrows(InvalidDataException.class, () -> {o.setMail(null);});
        assertThrows(InvalidDataException.class, () -> {o.setMail("");});
        assertThrows(InvalidDataException.class, () -> {o.setMail("fadsfasdfasd");});
        o.setMail("mail2@gmail.com");
    }
}
