package dam.pharmaSquare.model;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.pharmaSquare.model.persistencia.PProducto;

/**
 * Producto de la aplicación PharmaSquare.
 */
public class Producto {
    private Integer id;
    private String utilidad;
    private String nombre;
    private String laboratorio;
    private double precio;
    private int stock;
    private String foto;
    private boolean necesitaLogin;

    public Producto(Integer id, String utilidad, String nombre, String laboratorio, double precio, int stock,
                    String foto, String necesitaLogin) throws InvalidDataException {
        this.setId(id);
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    public Producto(String utilidad, String nombre, String laboratorio, double precio, int stock,
                    String foto, String necesitaLogin) throws InvalidDataException {
        this.id = PProducto.INVALID_ID;
        this.setUtilidad(utilidad);
        this.setNombre(nombre);
        this.setLaboratorio(laboratorio);
        this.setPrecio(precio);
        this.setStock(stock);
        this.setFoto(foto);
        this.setNecesitaLogin(necesitaLogin);
    }

    // CHECKERS
    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param id
     * @throws InvalidDataException
     */
    public static void isIdValid(Integer id) {
        if (!DataValidation.isNatural(id))
            throw new InvalidDataException("El id tiene que ser un natural mayor que 0.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param utilidad
     * @throws InvalidDataException
     */
    public static void isUtilidadValid(String utilidad) {
        if (!DataValidation.isStringValid(utilidad, PProducto.MIN_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que ser una frase de, al menos, " +
                    PProducto.MIN_UTILIDAD + " caracteres.");
        if (!DataValidation.isStringValid(utilidad, PProducto.MIN_UTILIDAD, PProducto.MAX_UTILIDAD))
            throw new InvalidDataException("La utilidad tiene que tener entre " +
                    PProducto.MIN_UTILIDAD + " y " + PProducto.MAX_UTILIDAD + " caracteres.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param nombre
     * @throws InvalidDataException
     */
    public static void isNombreValid(String nombre) {
        if (!DataValidation.isStringValid(nombre))
            throw new InvalidDataException("Este nombre introducido no es válido.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param laboratorio
     * @throws InvalidDataException
     */
    public static void isLaboratorioValid(String laboratorio) {
        if (!DataValidation.isStringValid(laboratorio))
            throw new InvalidDataException("El laboratorio no es un valor válido");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param precio
     * @throws InvalidDataException
     */
    public static void isPrecioValid(Double precio) {
        if (!DataValidation.isPositive(precio))
            throw new InvalidDataException("El precio tiene que ser un natural mayor que 0.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param stock
     * @throws InvalidDataException
     */
    public static void isStockValid(Integer stock) {
        if (!DataValidation.isNatural(stock))
            throw new InvalidDataException("El stock tiene que ser un natural mayor que 0.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param foto
     * @throws InvalidDataException
     */
    public static void isFotoValid(String foto) {
        if (!DataValidation.isStringValid(foto))
            throw new InvalidDataException("La foto introducida no es válida.");
    }

    /**
     * Lanza una InvalidDataException si el atributo introducido no es válido.
     * @param necesitaLogin
     * @throws InvalidDataException
     */
    public static void isNecesitaLoginValid(String necesitaLogin) {
        if (!DataValidation.isStringIn(necesitaLogin, PProducto.NECESITA_LOGIN_CHK))
            throw new InvalidDataException("El campo necesitaLogin debe ser %s", PProducto.NECESITA_LOGIN_CHK);
    }

    // SETTERS
    private void setId(int id) {
        isIdValid(id);
        this.id = id;
    }

    private void setUtilidad(String utilidad) {
        isUtilidadValid(utilidad);
        this.utilidad = utilidad;
    }

    private void setNombre(String nombre) {
        isNombreValid(nombre);
        this.nombre = nombre;
    }

    private void setLaboratorio(String laboratorio) {
        isLaboratorioValid(laboratorio);
        this.laboratorio = laboratorio;
    }

    private void setPrecio(double precio) {
        isPrecioValid(precio);
        this.precio = precio;
    }

    private void setStock(int stock) {
        isStockValid(stock);
        this.stock = stock;
    }

    private void setFoto(String foto) {
        isFotoValid(foto);
        this.foto = foto;
    }

    private void setNecesitaLogin(String necesitaLogin) {
        isNecesitaLoginValid(necesitaLogin);
        this.necesitaLogin = necesitaLogin.equals(PProducto.NECESITA_LOGIN_CHK[0]);
    }

    // GETTERS

    public Integer getId() {
        return id;
    }

    public String getUtilidad() {
        return utilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public String getFoto() {
        return foto;
    }

    public String getNecesitaLogin() {
        return PProducto.NECESITA_LOGIN_CHK[(necesitaLogin) ? 0 : 1];
    }

    public boolean isNecesitaLogin() {
        return necesitaLogin;
    }

    @Override
    public String toString() {
        return String.format(
          "Producto: %s\n  id: %s\n  utilidad: %s\n  laboratorio: %s\n  precio: %f\n  stock: %d\n  foto: %s\n necesitaLogin: " + this.isNecesitaLogin(),
          getNombre(), getId(), getUtilidad(), getLaboratorio(), getPrecio(), getStock(), getFoto()
        );
    }
}
