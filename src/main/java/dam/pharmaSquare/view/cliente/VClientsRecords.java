package dam.pharmaSquare.view.cliente;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Producto;
import dam.pharmaSquare.model.Transaccion;
import dam.pharmaSquare.model.persistencia.PTransaccion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class VClientsRecords extends JPanel {
    private JPanel jpBody;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JButton btnClock;
    private JLabel lblTitle;
    private JPanel jpComponents;
    private JLabel lblFiltro;
    private JComboBox cmbDate;
    private JComboBox cmbProd;
    private JTextField txtDniClt;
    private JButton btnSearch;
    private JTable tblRecords;
    private JScrollPane srpTable;
    private JLabel lblProducto;
    private JLabel lblDNICliente;
    private DefaultTableModel dtmRecords;
    private static PharmaSquareDB db;
    private DefaultComboBoxModel<String> dcbDate;

    public VClientsRecords(){
        add(jpBody);
        updateHour();
        init();
        configFields();
    }

    public void init(){
        srpTable.setViewportView(tblRecords);
        configTable();
        loadDataCmbxP();

        cmbDate.setModel(new DefaultComboBoxModel<String> (PharmaSquareDB.DATE));

        db = new PharmaSquareDB();
        ArrayList<Transaccion> list = db.getTransacciones(null, null, false);
        loadTable(list);

    }


    private void loadDataCmbxP() {
        db = new PharmaSquareDB();

        ArrayList<Producto> list = db.getProductos(true);

        cmbProd.addItem("Todos");
        for (Producto p : list) {
            cmbProd.addItem(p.getNombre());
        }
    }

    public void checkSearch() {
            String dni = txtDniClt.getText();
            String prod = (String) cmbProd.getSelectedItem();
            boolean cmbdDate;

            if (cmbDate.getSelectedItem() == "MÁS ANTIGUO") {
                cmbdDate = false;
            } else {
                cmbdDate = true;
            }

            if (dni.equals("") && prod.equals("")) {
                System.out.println("No se ha introducido ningun parametro");
                ArrayList<Transaccion> list = db.getTransacciones(null, null, cmbdDate);
                loadTable(list);
            } else if (!dni.equals("") || prod.contains("Todos")) {
                System.out.println("Todos");
                ArrayList<Transaccion> list = db.getTransacciones(null, null, cmbdDate);
                loadTable(list);
            } else if (dni.equals("") && !prod.equals("")) {
                System.out.println("Producto");
                ArrayList<Transaccion> list = db.getTransacciones(null, prod, cmbdDate);
                loadTable(list);
            } else if (!dni.equals("") && prod.equals("")) {
                System.out.println("DNI");
                ArrayList<Transaccion> list = db.getTransacciones(dni, null, cmbdDate);
                loadTable(list);
                // else if todos prod
            } else {
                System.out.println("DNI y Producto");
                ArrayList<Transaccion> list = db.getTransacciones(dni, prod, cmbdDate);
                loadTable(list);
            }

    }

    private void configTable() {
        dtmRecords = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        } ;

        tblRecords.setModel(dtmRecords);

        dtmRecords.addColumn(PTransaccion.FECHA);
        dtmRecords.addColumn(PTransaccion.DNI);
        dtmRecords.addColumn(PTransaccion.ID_PRODUCTO);
        dtmRecords.addColumn(PTransaccion.CANTIDAD);

        tblRecords.getColumn(PTransaccion.FECHA).setPreferredWidth(100);
        tblRecords.getColumn(PTransaccion.DNI).setPreferredWidth(80);
        tblRecords.getColumn(PTransaccion.ID_PRODUCTO).setPreferredWidth(80);
        tblRecords.getColumn(PTransaccion.CANTIDAD).setPreferredWidth(40);

        tblRecords.setRowHeight(30);
    }

    public void loadTable(ArrayList<Transaccion> list){

        Object[] fila = new Object[4];
        dtmRecords.setRowCount(0);

        for(Transaccion t :list) {
            fila[0] = t.getFecha();
            fila[1] = t.getDni();
            fila[2] = t.getIdProducto();
            fila[3] = t.getCantidad();
            dtmRecords.addRow(fila);
        }
    }

    /**
     * method that return the text value of the JTextField
     * @return name JtextField text
     */
    public String getTextFieldValue() {
        String name = txtDniClt.getText();
        return  name;
    }

    public void setController(Controller c) {
        btnBack.addActionListener(c);
        btnSearch.addActionListener(c);
    }

    private void configFields() {
        defaultAll();

        txtDniClt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniClt.setText("");
                txtDniClt.setForeground(new java.awt.Color(0, 0, 0));
            }
        });
    }

    public void updateHour() {
        btnClock.setText("00:00h");
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnClock.setText(getCurrentHour());
            }
        });
        timer.start();
    }

    private String getCurrentHour() {
        //Get hour and minutes from the system
        String hour = "";
        String minutes = "";

        hour = String.valueOf(LocalTime.now().getHour());
        minutes = String.valueOf(LocalTime.now().getMinute());

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

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnSearch() {
        return btnSearch;
    }

    public void defaultAll() {
        txtDniClt.setForeground(new java.awt.Color(153, 153, 153));
        cmbDate.setSelectedIndex(0);
        cmbProd.setSelectedIndex(0);
    }
}
