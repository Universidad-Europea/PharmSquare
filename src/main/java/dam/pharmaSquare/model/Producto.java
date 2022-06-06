package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PProducto;

public class Producto {
    private Integer id;
    private String utilidad;
    private String nombre;
    private String laboratorio;
    private int precio;
    private int stock;
    private String foto;
    private boolean necesitaLogin;

    public Producto(Integer id, String utilidad, String nombre, String laboratorio, int precio, int stock, String foto, String necesitaLogin) {
        this.setId(id);
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    public Producto(String utilidad, String nombre, String laboratorio, int precio, int stock, String foto, String necesitaLogin) {
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    // SETTERS
    public void setId(int id) {
        if (!DataValidation.isNatural(id))
            throw new InvalidDataException("El id tiene que ser un natural mayor que 0.");
        this.id = id;
    }

    public void setUtilidad(String utilidad) {
        if (!DataValidation.isValidDescription(PProducto.MIN_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que ser una frase de, al menos, " +
                    PProducto.MIN_UTILIDAD + " caracteres.");
        if (!DataValidation.isValidDescription(PProducto.MIN_UTILIDAD, PProducto.MAX_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que tener entre " +
                    PProducto.MIN_UTILIDAD + " y " + PProducto.MAX_UTILIDAD + " caracteres.");
        this.utilidad = utilidad;
    }

    public void setNombre(String nombre) {
        if (!DataValidation.isNameValid(nombre))
            throw new InvalidDataException("Este nombre introducido no es válido.");
        this.nombre = nombre;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setNecesitaLogin(String necesitaLogin) {
        this.necesitaLogin = necesitaLogin;
    }
}
