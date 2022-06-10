package dam.pharmaSquare.view.products;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;

import javax.swing.*;
import java.util.ArrayList;

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

    public VModifyProducts() {
        add(jpBody);
        loadDataCmbx();
    }

    //edit mode
    public void editMode(int type) {

        System.out.println(type);

        if (type % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Modo edicion: deshabilitado");
            enableAll();
        } else if (type % 2 == 1) {
            JOptionPane.showMessageDialog(null, "Modo edicion: habilitado");
            enableAll();
            btnEliminar.setEnabled(false);
            txtIDProduct.setEnabled(false); // La ID no es modificable
        }

    }

    public void updateProductDB() {
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(spnPrecio.getValue().toString());
        int stock = Integer.parseInt(spnStock.getValue().toString());
        String utilidad = txtUtilidad.getText();
        String laboratorio = txtLaboratorio.getText();
        String necesitaLogin = String.valueOf(rdbSi.isSelected());
        if (necesitaLogin.equals("true")) {
            necesitaLogin = "S";
        } else {
            necesitaLogin = "N";
        }
        int idProduc = Integer.parseInt(txtIDProduct.getText());
        //     public int updateProducto(String nombre, String precio, String stock, String utilidad, String login, String laboratorio, String id) {

        //db.updateProducto(nombre, precio, stock, utilidad, necesitaLogin, laboratorio, idProduc);
        System.out.println("Producto actualizado");
        //System.out.println(db.updateProducto(nombre, precio, stock, utilidad, necesitaLogin, laboratorio, idProduc));

    }

    public void eliminarSeleccion() {
        int selectedRow = cmbxData.getSelectedIndex();
        if (selectedRow != -1) {
            String product = cmbxData.getSelectedItem().toString();
            db.delProducto(product);
            cmbxData.removeItemAt(selectedRow);
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
           // enableAll();
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
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnModificar.setEnabled(true);
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



