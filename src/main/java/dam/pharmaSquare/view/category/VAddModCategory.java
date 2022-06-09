package dam.pharmaSquare.view.category;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.persistencia.PCategoriaProducto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    private static final String CATEGORY_NAME = "NOMBRE";
    private static final String SAVE_NEW_C = "GUADAR ";
    private static final String SAVE_CHANGES = "GUADAR CAMBIOS";
    private static final String DELETE = "BORRAR";

    private JPanel jpBody;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JButton btnClock;
    private JPanel jpComponents;
    private JTextField txtNewCtgName;
    private JLabel lblNewCtg;
    private JLabel lblNewCtgNm;
    private JLabel lblModCtg;
    private JTextField textField1;
    private JLabel lblModCtgNm;
    private JButton btnSaveChanges;
    private JTable tblCtg;
    private JScrollPane scrpTable;
    private JButton btnSaveNewCtg;
    private JButton btnDelete;
    private DefaultTableModel dtmCtg;

    /**
     * method calling private methods
     * - add(jpBody)
     * @param jpBody is the Jpanel that contains all the swing elements
     * @return the component argument
     */

    public void VAddModCategory(){
        init();
        add(jpBody);
        updateHour();
    }

    /**
     * initializes the Swing components
     */
    private void init(){
        scrpTable.setViewportView(tblCtg);

        configTable();
    }

    private void configTable() {
        tblCtg.setModel(dtmCtg);

        //adding and setting the columns
        dtmCtg.addColumn(PCategoriaProducto.NOMBRE);
        tblCtg.getColumn(PCategoriaProducto.NOMBRE).setPreferredWidth(150);

        tblCtg.setRowHeight(30);
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     * @param  c The controller to listen to the buttons
     */

    public void setController(Controller c){
        btnSaveChanges.addActionListener(c);
        btnSaveNewCtg.addActionListener(c);
        btnDelete.addActionListener(c);
    }

    /**
     * method that return the text value of the JTextField
     * @return name JtextField text
     */
    public String getTextFieldValueNewC() {
        String name = txtNewCtgName.getText();
        return  name;
    }

    //ANYONE KNOWS HOW CAN I REFACTOR THIS ???
    /**
     * method that return the text value of the JTextField
     * @return name JtextField text
     */
    public String getTextFieldValueModC() {
        String name = txtNewCtgName.getText();
        return  name;
    }

    /**
     * method that return a String with value of the selected row in the table
     * @return type JTable row value
     */
    public String getSelectedItem(){
        int column = 0;
        int row = tblCtg.getSelectedRow();
        return  tblCtg.getModel().getValueAt(row, column).toString();
    }

    public void updateHour() {

        btnClock.setText("00:00h");
        Timer timer = new Timer(1000, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClock.setText(getCurrentHour());
            }
        });
        timer.start();

    }

    private String getCurrentHour() {
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
