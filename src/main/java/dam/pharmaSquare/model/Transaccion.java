package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;

public class Transaccion {
    private String dni;
    private int idProducto;
    private String fecha; // DateTime
    private String cantidad;

    public Transaccion(String dni, int idProducto, String fecha, String cantidad) {
        this.setDni(dni);
        this.setIdProducto(idProducto);
        this.setFecha(fecha);
        this.setCantidad(cantidad);
    }

    public void setDni(String dni) {
        if (!DataValidation.isDniValid(dni))
            throw new IllegalArgumentException("El DNI no es válido.");
        this.dni = dni;
    }

    public void setIdProducto(int idProducto) {
        if (!DataValidation.isNatural(idProducto))
            throw new IllegalArgumentException("El ID del producto no es válido.");
        this.idProducto = idProducto;
    }
}
