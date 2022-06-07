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

    // CHECKERS

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param id
     * @throws InvalidDataException
     */
    public static void isIdValid(Integer id) {
        if (!DataValidation.isNatural(id))
            throw new InvalidDataException("El id no es un natural.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param nombre
     * @throws InvalidDataException
     */
    public static void isNombreValid(String nombre) {
        if (!DataValidation.isStringValid(nombre))
            throw new InvalidDataException("El nombre de la categoría del producto no es válida.");
    }

    // SETTERS
    private void setId(Integer id) {
        isIdValid(id);
        this.id = id;
    }

    private void setNombre(String nombre) {
        isNombreValid(nombre);
        this.nombre = nombre;
    }
}
