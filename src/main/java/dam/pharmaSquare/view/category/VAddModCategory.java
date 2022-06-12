package dam.pharmaSquare.view.category;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.CategoriaProducto;
import dam.pharmaSquare.model.persistencia.PCategoriaProducto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * <h1>VAddModCategory</h1>
 * The VAddModCategory implements a JPanel that
 * display all the available categories and allows
 * the user to edit the name of a selected category
 * or add a new one.
 * This panel is composed of Swing elements.
 */


public class VAddModCategory extends JPanel {
    /**
     * Import and declare Swing elements of VAddModCategory.form
     * with some final String that we are going to work with in
     * the following methods
     */

    public static final String SAVE_NEW_C = "GUARDAR ";
    public static final String SAVE_CHANGES = "GUARDAR CAMBIOS";
    public static final String MODIFY = "MODIFICAR";
    public static final String EXIT = "VOLVER A STAFFMENU";

    private JPanel jpBody;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JButton btnClock;
    private JPanel jpComponents;
    private JTextField txtNewCtgName;
    private JLabel lblNewCtg;
    private JLabel lblNewCtgNm;
    private JLabel lblModCtg;
    private JTextField txtCtgMod;
    private JLabel lblModCtgNm;
    private JButton btnSaveChanges;
    private JTable tblCtg;
    private JScrollPane scrpTable;
    private JButton btnSaveNewCtg;
    private JButton btnMod;
    private JLabel lblId;
    private DefaultTableModel dtmCtg;
    private static PharmaSquareDB db;

    /**
     * method calling private methods
     * - add(jpBody)
     *
     * @param jpBody is the Jpanel that contains all the swing elements
     * @return the component argument
     */

    public void VAddModCategory() {
        init();
        add(jpBody);
        updateHour();
    }

    /**
     * initializes the Swing components
     */
    private void init() {
        scrpTable.setViewportView(tblCtg);
        configTable();
        loadTable();

        btnSaveNewCtg.setActionCommand(SAVE_NEW_C);
        btnMod.setActionCommand(MODIFY);
        btnSaveChanges.setActionCommand(SAVE_CHANGES);
        btnBack.setActionCommand(EXIT);
    }

    private void loadTable() {
        db = new PharmaSquareDB();

        ArrayList<CategoriaProducto> list = db.getCategorias();
        Object[] fila = new Object[4];
        dtmCtg.setRowCount(0);

        for (CategoriaProducto c : list) {
            fila[0] = c.getNombre();
            dtmCtg.addRow(fila);
        }

    }

    private void configTable() {
        tblCtg.setModel(dtmCtg);

        // declare DefaultTableModel and disable cell editing
        dtmCtg = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        };

        //adding and setting the columns
        dtmCtg.addColumn(PCategoriaProducto.NOMBRE);
        tblCtg.getColumn(PCategoriaProducto.NOMBRE).setPreferredWidth(150);

        tblCtg.setRowHeight(30);
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     *
     * @param c The controller to listen to the buttons
     */

    public void setController(Controller c) {
        btnSaveChanges.addActionListener(c);
        btnSaveNewCtg.addActionListener(c);
        btnMod.addActionListener(c);
        btnBack.addActionListener(c);
    }

    /**
     * method that return the text value of the JTextField
     *
     * @return name JtextField text
     */
    public CategoriaProducto getTextFieldValueNewC() {
       return new CategoriaProducto(Integer. parseInt(lblId.getText()),txtNewCtgName.getText());
    }

    /**
     * method that return the text value of the JTextField
     *
     * @return name JtextField text
     */
    public String getTextFieldValueModC() {
        String name = txtNewCtgName.getText();
        return name;
    }

    /**
     * method that return a String with value of the selected row in the table
     *
     * @return type JTable row value
     */
    public CategoriaProducto getSelectedItem() {
        ArrayList<CategoriaProducto> list = db.getCategorias();

        for (CategoriaProducto c : list) {
            if (c.getNombre().equals(tblCtg.getValueAt(tblCtg.getSelectedRow(), 0))) {
                return c;
            }
        }
        return null;
    }

    public void loadSelectedItem(CategoriaProducto c) {
        txtCtgMod.setText(c.getNombre());
        lblId.setText(c.getId() + "");
    }

    public void cleanComponents() {
        txtNewCtgName.setText("");
        txtCtgMod.setText("");
        lblId.setText("");
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

