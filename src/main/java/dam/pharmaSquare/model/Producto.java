package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PProducto;

public class Producto {
    private Integer id;
    private String utilidad;
    private String nombre;
    private String laboratorio;
    private double precio;
    private int stock;
    private String foto;
    private boolean necesitaLogin;

    public Producto(Integer id, String utilidad, String nombre, String laboratorio, double precio, int stock, String foto, String necesitaLogin) {
        this.setId(id);
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    public Producto(String utilidad, String nombre, String laboratorio, double precio, int stock, String foto, String necesitaLogin) {
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    // SETTERS
    private void setId(int id) {
        if (!DataValidation.isNatural(id))
            throw new InvalidDataException("El id tiene que ser un natural mayor que 0.");
        this.id = id;
    }

    private void setUtilidad(String utilidad) {
        if (!DataValidation.isStringValid(utilidad, PProducto.MIN_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que ser una frase de, al menos, " +
                    PProducto.MIN_UTILIDAD + " caracteres.");
        if (!DataValidation.isStringValid(utilidad, PProducto.MIN_UTILIDAD, PProducto.MAX_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que tener entre " +
                    PProducto.MIN_UTILIDAD + " y " + PProducto.MAX_UTILIDAD + " caracteres.");
        this.utilidad = utilidad;
    }

    private void setNombre(String nombre) {
        if (!DataValidation.isNameValid(nombre))
            throw new InvalidDataException("Este nombre introducido no es válido.");
        this.nombre = nombre;
    }

    private void setLaboratorio(String laboratorio) {
        if (!DataValidation.isStringValid(laboratorio))
            throw new InvalidDataException("El laboratorio no es un valor válido");
        this.laboratorio = laboratorio;
    }

    private void setPrecio(double precio) {
        if (!DataValidation.isPositive(precio))
            throw new InvalidDataException("El precio tiene que ser un natural mayor que 0.");
        this.precio = precio;
    }

    private void setStock(int stock) {
        if (!DataValidation.isNatural(stock))
            throw new InvalidDataException("El stock tiene que ser un natural mayor que 0.");
        this.stock = stock;
    }

    private void setFoto(String foto) {
        if (!DataValidation.isStringValid(foto))
            throw new InvalidDataException("La foto introducida no es válida.");
        this.foto = foto;
    }

    private void setNecesitaLogin(String necesitaLogin) {
        if (!DataValidation.isStringIn(necesitaLogin, PProducto.NECESITA_LOGIN_CHK))
            throw new InvalidDataException("El campo necesitaLogin debe ser %s", PProducto.NECESITA_LOGIN_CHK);
        this.necesitaLogin = necesitaLogin.equals(PProducto.NECESITA_LOGIN_CHK[0]);
    }
}
