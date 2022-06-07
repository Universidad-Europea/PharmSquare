package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PPersonal;

/**
 * Personal de la aplicación PharmaSquare.
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

    private void setDni(String dni) {
        if (!DataValidation.isDniValid(dni))
            throw new InvalidDataException("The DNI given is not valid.");
        this.dni = dni;
    }

    private void setNombre(String nombre) {
        if (!DataValidation.isNameValid(nombre))
            throw new InvalidDataException("El nombre introducido no es válido.");
        this.nombre = nombre;
    }

    private void setCategoria(String categoria) {
        if (!DataValidation.isStringIn(categoria, PPersonal.CATEGORIAS_CHK))
            throw new InvalidDataException("La categoría introducida no es válida.");
        this.categoria = categoria;
    }

    private void setPasswd(String passwd) {
        // TODO validar password?
        this.passwd = passwd;
    }
}
