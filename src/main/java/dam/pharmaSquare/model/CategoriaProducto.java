package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;

/**
 * Categoria de un producto de la aplicación PharmaSquare.
 */
public class CategoriaProducto {
    private Integer id;
    private String nombre;

    public CategoriaProducto(Integer id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    private void setId(Integer id) {
        if (!DataValidation.isNatural(id))
            throw new InvalidDataException("El id no es un natural.");
        this.id = id;
    }

    private void setNombre(String nombre) {
        if (!DataValidation.isStringValid(nombre))
            throw new InvalidDataException("El nombre de la categoría del producto no es válida.");
        this.nombre = nombre;
    }
}
