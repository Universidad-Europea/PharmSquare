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
    public JComboBox cmbxData;
    private JTextField txtIDProduct;
    private JButton btnNewSearch;
    private JButton btnClock;
    private JButton btnStaff;
    private JButton btnGuardar;
    private JButton btnModificar;
    private static PharmaSquareDB db;

    public VModifyProducts() {
        add(jpBody);
        updateHour();
        loadDataCmbx();
    }

    public void editMode(int type) {

        System.out.println(type);

        if (type % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Modo edicion: deshabilitado");
            disableAllExeptCmbx();
        } else if (type % 2 == 1) {
            JOptionPane.showMessageDialog(null, "Modo edicion: habilitado");
            enableAll();
            txtIDProduct.setEnabled(false); // La ID no es modificable
        }

    }

    public void updateProductDB() {
        int id = Integer.parseInt(txtIDProduct.getText());
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

        Producto producto = new Producto(id, utilidad, nombre, laboratorio, precio, stock, "img/productos/apositos.png", necesitaLogin);

        db.modProducto(producto);

    }

    public void eliminarSeleccion() {
        int selectedRow = cmbxData.getSelectedIndex();
        if (selectedRow != -1) {
            String product = cmbxData.getSelectedItem().toString();
            db.delProducto(product);
            cmbxData.removeItemAt(selectedRow);
        }
    }

    public void loadDataCmbx() {
        db = new PharmaSquareDB();

        ArrayList<Producto> list = db.getProductos(true);
        System.out.println(cmbxData.getSelectedIndex());
        for (Producto p : list) {
            cmbxData.addItem(p.getNombre());
        }

        disableAllExeptCmbx();

        cmbxData.addActionListener(e -> {

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
        spnPrecio.setModel( new SpinnerNumberModel(1, 1, 100, 0.1));
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
        btnEliminar.setEnabled(true);
        btnGuardar.setEnabled(false);
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

    public JButton getBtnStaff() {
        return btnStaff;
    }

    public void setController(Controller controller) {
        btnStaff.addActionListener(controller);
        btnEliminar.addActionListener(controller);
        btnGuardar.addActionListener(controller);
        btnModificar.addActionListener(controller);
    }

    public void updateHour () {

        btnClock.setText("00:00h");
        Timer timer = new Timer(1000, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClock.setText(getCurrentHour());
            }
        });
        timer.start();

    }

    private String getCurrentHour () {
        //Get hour and minutes from the system
        String hour = "";
        String minutes = "";

        hour = String.valueOf(java.time.LocalTime.now().getHour());
        minutes = String.valueOf(java.time.LocalTime.now().getMinute());

        if (hour.length() == 1) {
            hour = "0" + hour;
        } else {
            hour = hour;
        }

        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        } else {
            minutes = minutes;
        }

        return hour + ":" + minutes + "h";
    }

}



