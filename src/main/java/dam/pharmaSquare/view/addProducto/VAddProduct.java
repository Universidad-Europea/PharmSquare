package dam.pharmaSquare.view.addProducto;

import javax.swing.*;

public class VAddProduct {
    private JPanel jpBody;
    private JButton btnBack;
    private JPanel jpTopElements;
    private JLabel lblTime;
    private JPanel jpForm;
    private JLabel lblNumProd;
    private JTextField txtNombre;
    private SpinnerModel model;
    private JSpinner spnPrecio;
    private JSpinner spnStock;
    private JComboBox cmbCategoria;
    private JLabel lblNombre;
    private JTextArea txtUtilidad;
    private JRadioButton rdbSi;
    private JRadioButton rdbNo;
    private JButton btnGuardar;
    private JLabel lblTitle;
    private JLabel lblPrecio;
    private JLabel lblStock;
    private JLabel lblCategorias;
    private JLabel lblLaboratorio;
    private JTextField txtLaboratorio;
    private JLabel lblUtilidad;
    private JLabel lblLogin;

    public VAddProduct(){
        init();
    }

    private void init() {
        spnPrecio.setModel( new SpinnerNumberModel(1, 1, 100, 1));
        spnStock.setModel( new SpinnerNumberModel(1, 1, 100, 1));
    }
}



