package dam.pharmaSquare.view.cliente;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;

import javax.swing.*;

/**
 * <h1>VModClient</h1>
 * The VModClient implements a JPanel that display
 * all the information of a specific clients and allows
 * the user to edit/delete them.
 * This panel is composed of Swing elements.
 */

public class VModClient extends JPanel {
    /**
     * Import and declare Swing elements of VAddModCategory.form
     * with some final String that we are going to work with in
     * the following methods
     */

    private static final String SEARCH = "BUSCAR";
    private static final String SAVE = "GUARDAR CAMBIOS";
    private static final String DELETE = "BORRAR";

    private JPanel jpBody;
    private JButton btnBack;
    private JButton btnClock;
    private JTextField txtIdClt;
    private JButton btnSearch;
    private JButton btnDelete;
    private JLabel lblId;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtDni;
    private JTextField txtFecNac;
    private JComboBox cmbGender;
    private JTextField txtNumber;
    private JTextField txtAddress;
    private JComboBox cmbTown;
    private JTextField txtMail;
    private JButton btnSave;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblDni;
    private JLabel lblFecNac;
    private JLabel lblGender;
    private JLabel lblNumber;
    private JLabel lblAddress;
    private JLabel lblTown;
    private JLabel lblMail;
    private static PharmaSquareDB db;


    /**
     * method calling private methods
     * - add(jpBody)
     * @param jpBody is the Jpanel that contains all the swing elements
     * @return the component argument
     */

    public void VAddModCategory(){
        add(jpBody);
        updateHour();
        init();
    }

    /**
     * initializes the Swing components
     */
    public void init(){
        disableAllExceptTxtId();
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     * @param  c The controller to listen to the buttons
     */
    public void setController(Controller c) {
        btnSave.addActionListener(c);
        btnDelete.addActionListener(c);
        btnSearch.addActionListener(c);
    }

    /**
     * method that return the text value of the JTextField
     * @return name JtextField text
     */
    public String getTextFieldValue() {
        String name = txtIdClt.getText();
        return  name;
    }

    /**
     * method that receives the complete information of a client
     * and display it
     * @param  c An objet of type Client
     */
    public void loadData(Cliente c){
        enableAll();
        txtName.setText(c.getNombre());
        //txtSurname.setText(c.get);
        txtDni.setText(c.getDni());
        txtFecNac.setText(c.getNacimiento());
        cmbGender.setSelectedItem(c.getSexo());
        txtNumber.setText(c.getTelefono());
        txtAddress.setText(c.getDireccion());
        //cmbTown.setSelectedItem(c.get);
        txtMail.setText(c.getMail());

    }

    private void enableAll() {
        txtIdClt.setEnabled(false);
        txtName.setEnabled(true);
        txtSurname.setEnabled(true);
        txtDni.setEnabled(true);
        txtFecNac.setEnabled(true);
        cmbGender.setEnabled(true);
        txtNumber.setEnabled(true);
        txtAddress.setEnabled(true);
        cmbTown.setEnabled(true);
        txtMail.setEnabled(true);
    }

    /**
     * method that only allows to edit text area of the first JTextField
     * for the search and cleans the rest of the components
     */
    private void disableAllExceptTxtId() {
        txtIdClt.setEnabled(true);

        txtName.setText("");
        txtSurname.setText("");
        txtDni.setText("");
        txtFecNac.setText("");
        cmbGender.setSelectedIndex(0);
        txtNumber.setText("");
        txtAddress.setText("");
        cmbTown.setSelectedIndex(0);
        txtMail.setText("");

        txtName.setEnabled(false);
        txtSurname.setEnabled(false);
        txtDni.setEnabled(false);
        txtFecNac.setEnabled(false);
        cmbGender.setEnabled(false);
        txtNumber.setEnabled(false);
        txtAddress.setEnabled(false);
        cmbTown.setEnabled(false);
        txtMail.setEnabled(false);
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
