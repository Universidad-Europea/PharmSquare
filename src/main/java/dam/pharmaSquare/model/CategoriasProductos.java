package dam.pharmaSquare.model;

import java.util.ArrayList;

/**
 * Clase que contiene un producto, así como todas sus categorías.
 *
 * @author Jorge Re - Jkutkut
 */
public class CategoriasProductos {
    private Producto producto;
    private ArrayList<CategoriaProducto> categorias;

    public CategoriasProductos(Producto producto, ArrayList<CategoriaProducto> categorias) {
        this.producto = producto;
        this.categorias = categorias;
    }

    // GETTERS

    public Producto getProducto() {
        return producto;
    }

    public ArrayList<CategoriaProducto> getCategorias() {
        return categorias;
    }
}
