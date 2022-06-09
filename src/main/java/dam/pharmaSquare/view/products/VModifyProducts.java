package dam.pharmaSquare.view.products;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;

import javax.swing.*;
import java.util.ArrayList;

public class VModifyProducts extends JPanel {
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
    private JLabel lblLaboratorio;
    private JTextField txtLaboratorio;
    private JLabel lblUtilidad;
    private JLabel lblLogin;
    private JComboBox cmbxData;
    private JTextField txtIDProduct;
    private JButton btnNewSearch;
    private static PharmaSquareDB db;

    public VModifyProducts(){
        add(jpBody);
        loadDataCmbx();
    }

    private void loadDataCmbx() {
        db = new PharmaSquareDB();

        ArrayList<Producto> list = db.getProductos(true);
        for (Producto p : list) {
            cmbxData.addItem(p.getNombre());
        }

        // Disable all components
        disableAllExeptCmbx();

        // When the user selects an item, enable the components
        cmbxData.addActionListener(e -> {
            enableAll();
            Producto p = db.getProductos(true).get(cmbxData.getSelectedIndex());
            txtNombre.setText(p.getNombre());
            spnPrecio.setValue(p.getPrecio());
            spnStock.setValue(p.getStock());
            txtUtilidad.setText(p.getUtilidad());
            if (p.isNecesitaLogin()) {
                rdbSi.setSelected(true);
            } else {
                rdbNo.setSelected(true);
            }
            txtLaboratorio.setText(p.getLaboratorio());
        });

    }

    private void enableAll() {
        disableAllExeptCmbx();
        txtNombre.setEnabled(true);
        spnPrecio.setEnabled(true);
        spnStock.setEnabled(true);
        txtUtilidad.setEnabled(true);
        rdbSi.setEnabled(true);
        rdbNo.setEnabled(true);
        txtLaboratorio.setEnabled(true);
    }

    private void disableAllExeptCmbx() {
        cmbxData.setEnabled(true);

        txtNombre.setText("");
        spnPrecio.setModel( new SpinnerNumberModel(1, 1, 100, 1));
        spnStock.setModel( new SpinnerNumberModel(1, 1, 100, 1));
        txtUtilidad.setText("");
        rdbSi.setSelected(false);
        rdbNo.setSelected(false);
        txtLaboratorio.setText("");


        txtNombre.setEnabled(false);
        spnPrecio.setEnabled(false);
        spnStock.setEnabled(false);
        txtUtilidad.setEnabled(false);
        rdbSi.setEnabled(false);
        rdbNo.setEnabled(false);
        txtLaboratorio.setEnabled(false);
    }
}



