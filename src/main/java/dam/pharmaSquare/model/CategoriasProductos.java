package dam.pharmaSquare.model;

import java.util.ArrayList;

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
