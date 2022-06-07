package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PCliente;

/**
 * Cliente de la aplicación PharmaSquare.
 */
public class Cliente {

    private String dni;
    private String nombre;
    private String fAlta; // TODO Date?
    private String direccion;
    private String nacimiento; // TODO Date?
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

    // SETTERS
    public void setDni(String dni) {
        if (!DataValidation.isDniValid(dni))
            throw new InvalidDataException("El DNI introducido no es válido.");
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        if (!DataValidation.isNameValid(nombre))
            throw new InvalidDataException("El nombre introducido no es válido");
        this.nombre = nombre;
    }

    public void setFAlta(String fAlta) {
        // TODO verificar fecha?
        this.fAlta = fAlta;
    }

    public void setDireccion(String direccion) {
        if (!DataValidation.isStringValid(direccion))
            throw new InvalidDataException("La dirección introducida no es válida.");
        this.direccion = direccion;
    }

    public void setNacimiento(String nacimiento) {
        // TODO verificar fecha?
        this.nacimiento = nacimiento;
    }

    public void setPasswd(String passwd) {
        // TODO verificar password? O mejor en el formulario para poder hacer cuentas con contraseñas malas?
        this.passwd = passwd;
    }

    public void setSexo(String sexo) {
        if (!DataValidation.isStringIn(sexo, PCliente.SEXO_CHK))
            throw new InvalidDataException("El sexo introducido no es válido.");
        this.sexo = sexo;
    }

    public void setTelefono(String telefono) {
        if (!DataValidation.isPhoneValid(telefono))
            throw new InvalidDataException("El teléfono introducido no es válido.");
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        if (!DataValidation.isMailValid(mail))
            throw new InvalidDataException("El mail introducido no es válido");
        this.mail = mail;
    }
}
