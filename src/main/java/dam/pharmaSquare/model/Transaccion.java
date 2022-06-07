package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;

/**
 * Transacción de la aplicación PharmaSquare.
 */
public class Transaccion {
    private String dni;
    private int idProducto;
    private String fecha; // DateTime
    private double cantidad;

    public Transaccion(String dni, int idProducto, String fecha, double cantidad) {
        this.setDni(dni);
        this.setIdProducto(idProducto);
        this.setFecha(fecha);
        this.setCantidad(cantidad);
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
     * @param idProducto
     * @throws InvalidDataException
     */
    public static void isIdProductoValid(Integer idProducto) {
        if (!DataValidation.isNatural(idProducto))
            throw new IllegalArgumentException("El ID del producto no es válido.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param fecha
     * @throws InvalidDataException
     */
    public static void isFechaValid(String fecha) {
        // TODO Validar fecha
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param cantidad
     * @throws InvalidDataException
     */
    public static void isCantidadValid(double cantidad) {
        if (!DataValidation.isPositive(cantidad))
            throw new IllegalArgumentException("La cantidad no es válida.");
    }

    // SETTERS
    public void setDni(String dni) {
        isDniValid(dni);
        this.dni = dni;
    }

    public void setIdProducto(int idProducto) {
        isIdProductoValid(idProducto);
        this.idProducto = idProducto;
    }

    public void setFecha(String fecha) {
        isFechaValid(fecha);
        this.fecha = fecha;
    }

    public void setCantidad(double cantidad) {
        isCantidadValid(cantidad);
        this.cantidad = cantidad;
    }
}
