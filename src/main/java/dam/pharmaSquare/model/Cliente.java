package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PCliente;


/**
 * Cliente de la aplicación PharmaSquare.
 *
 * @author Jorge Re - Jkutkut
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String fAlta;
    private String direccion;
    private String nacimiento;
    private String passwd;
    private String sexo;
    private String telefono;
    private String mail;

    public Cliente(String dni, String nombre, String fAlta, String direccion, String nacimiento, String passwd,
                   String sexo, String telefono, String mail) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setFAlta(fAlta);
        this.setDireccion(direccion);
        this.setNacimiento(nacimiento);
        this.setPasswd(passwd);
        this.setSexo(sexo);
        this.setTelefono(telefono);
        this.setMail(mail);
    }
    public Cliente(String dni, String nombre, String direccion, String nacimiento,
                   String sexo, String telefono, String mail) {
        this.setNombre(nombre);
        this.setDireccion(direccion);
        this.setNacimiento(nacimiento);
        this.setSexo(sexo);
        this.setTelefono(telefono);
        this.setMail(mail);
    }

    // CHECKERS
    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param dni
     * @throws InvalidDataException
     */
    public static void isDniValid(String dni) {
        if (!DataValidation.isDniValid(dni))
            throw new InvalidDataException("El DNI introducido no es válido.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param nombre
     * @throws InvalidDataException
     */
    public static void isNombreValid(String nombre) {
        if (!DataValidation.isNameValid(nombre))
            throw new InvalidDataException("El nombre introducido no es válido");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param fAlta
     * @throws InvalidDataException
     */
    public static void isFAltaValid(String fAlta) {
        if (!DataValidation.isDateValid(fAlta))
            throw new InvalidDataException("La fecha introducida no es válida.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param direccion
     * @throws InvalidDataException
     */
    public static void isDireccionValid(String direccion) {
        if (!DataValidation.isStringValid(direccion))
            throw new InvalidDataException("La dirección introducida no es válida.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param nacimiento
     * @throws InvalidDataException
     */
    public static void isNacimientoValid(String nacimiento) {
        // TODO verificar fecha?
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param passwd
     * @throws InvalidDataException
     */
    public static void isPasswdValid(String passwd) {
        // TODO verificar password? O mejor en el formulario para poder hacer cuentas con contraseñas malas?
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param sexo
     * @throws InvalidDataException
     */
    public static void isSexoValid(String sexo) {
        if (!DataValidation.isStringIn(sexo, PCliente.SEXO_CHK))
            throw new InvalidDataException("El sexo introducido no es válido.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param telefono
     * @throws InvalidDataException
     */
    public static void isTelefonoValid(String telefono) {
        if (!DataValidation.isPhoneValid(telefono))
            throw new InvalidDataException("El teléfono introducido no es válido.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param mail
     * @throws InvalidDataException
     */
    public static void isMailValid(String mail) {
        if (!DataValidation.isMailValid(mail))
            throw new InvalidDataException("El mail introducido no es válido");
    }

    // SETTERS
    public void setDni(String dni) {
        isDniValid(dni);
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        isNombreValid(nombre);
        this.nombre = nombre;
    }

    public void setFAlta(String fAlta) {
        isFAltaValid(fAlta);
        this.fAlta = fAlta;
    }

    public void setDireccion(String direccion) {
        isDireccionValid(direccion);
        this.direccion = direccion;
    }

    public void setNacimiento(String nacimiento) {
        isNacimientoValid(nacimiento);
        this.nacimiento = nacimiento;
    }

    public void setPasswd(String passwd) {
        isPasswdValid(passwd);
        this.passwd = passwd;
    }

    public void setSexo(String sexo) {
        isSexoValid(sexo);
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        isTelefonoValid(telefono);
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        isMailValid(mail);
        this.mail = mail;
    }

    // GETTERS

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getfAlta() {
        return fAlta;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getSexo() {
        return sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fAlta='" + fAlta + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", passwd='" + passwd + '\'' +
                ", sexo='" + sexo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
