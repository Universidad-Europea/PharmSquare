package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PPersonal;

/**
 * Personal de la aplicación PharmaSquare.
 *
 * @author Jorge Re - Jkutkut
 */
public class Personal {
    private String dni;
    private String nombre;
    private String categoria;
    private String passwd;

    public Personal(String dni, String nombre, String categoria, String passwd) {
        this.setDni(dni);
        this.setNombre(nombre);
        this.setCategoria(categoria);
        this.setPasswd(passwd);
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
     * @param categoria
     * @throws InvalidDataException
     */
    public static void isCategoriaValid(String categoria) {
        if (!DataValidation.isStringIn(categoria, PPersonal.CATEGORIAS_CHK))
            throw new InvalidDataException("La categoría introducida no es válida.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param passwd
     * @throws InvalidDataException
     */
    public static void isPasswdValid(String passwd) {
        // TODO validar password?
    }

    // SETTERS
    private void setDni(String dni) {
        isDniValid(dni);
        this.dni = dni;
    }

    private void setNombre(String nombre) {
        isNombreValid(nombre);
        this.nombre = nombre;
    }

    private void setCategoria(String categoria) {
        isCategoriaValid(categoria);
        this.categoria = categoria;
    }

    private void setPasswd(String passwd) {
        isPasswdValid(passwd);
        this.passwd = passwd;
    }

    // GETTERS
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPasswd() {
        return passwd;
    }
}
