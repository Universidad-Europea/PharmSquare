package dam.pharmaSquare.view.products;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class VModifyProducts extends JPanel {
    private JPanel jpBody;
    private JPanel jpTopElements;
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
    private JButton btnEliminar;
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
    private JButton btnClock;
    private JButton btnStaff;
    private JButton btnGuardar;
    private JButton btnModificar;
    private static PharmaSquareDB db;

    public VModifyProducts(){
        add(jpBody);
        loadDataCmbx();
    }

    public void modoEdicion(boolean b) {
        boolean modoEdicion = b;
        System.out.println("modoEdicion: " + modoEdicion);

        if (modoEdicion == true) {
            JOptionPane.showMessageDialog(null, "Modo edición activado");
            btnEliminar.setEnabled(false);
        }
    }

    public void eliminarSeleccion() {
        int selectedRow = cmbxData.getSelectedIndex();
        if (selectedRow != -1) {
            String product = cmbxData.getSelectedItem().toString();
            db.delProducto(product);
            loadDataCmbx();
        }
    }

    private void loadDataCmbx() {

        db = new PharmaSquareDB();

        ArrayList<Producto> list = db.getProductos(true);
        for (Producto p : list) {
            cmbxData.addItem(p.getNombre());
        }

        disableAllExeptCmbx();

        cmbxData.addActionListener(e -> {
            enableAll();
            Producto p = db.getProductos(true).get(cmbxData.getSelectedIndex());
            txtNombre.setText(p.getNombre());
            spnPrecio.setValue(p.getPrecio());
            spnStock.setValue(p.getStock());
            txtIDProduct.setText(String.valueOf(p.getId()));
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
        txtIDProduct.setEnabled(true);
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
        txtIDProduct.setEnabled(false);
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setController(Controller controller) {
        btnEliminar.addActionListener(controller);
        btnGuardar.addActionListener(controller);
        btnModificar.addActionListener(controller);
    }
}



