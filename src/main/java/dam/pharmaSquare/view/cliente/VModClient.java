package dam.pharmaSquare.view.cliente;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.time.LocalTime;
import java.util.List;

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

    public static final String SEARCH = "BUSCAR";
    public static final String SAVE = "GUARDAR CAMBIOS";
    public static final String DELETE = "BORRAR";
    public static final String EXIT = "VOLVER A STAFFMENU";
    private static final String[] GENDER_LIST = {"Femenino", "Masculino", "Otro"};

    private JPanel jpBody;
    private JButton btnBack;
    private JButton btnClock;
    private JTextField txtIdClt;
    private JButton btnSearch;
    private JButton btnDelete;
    private JLabel lblId;
    private JTextField txtName;
    private JTextField txtDni;
    private JTextField txtFecNac;
    private JComboBox cmbGender;
    private JTextField txtNumber;
    private JTextField txtAddress;
    private JTextField txtMail;
    private JButton btnSave;
    private JLabel lblName;
    private JLabel lblDni;
    private JLabel lblFecNac;
    private JLabel lblGender;
    private JLabel lblNumber;
    private JLabel lblAddress;
    private JLabel lblMail;
    private JPanel jpTopElements;
    private JPanel jpForm;
    private DefaultComboBoxModel<String> dcbGender;


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
        configFields();
        disableAllExceptTxtId();
        loadCmb();

        btnSave.setActionCommand(SAVE);
        btnDelete.setActionCommand(DELETE);
        btnSearch.setActionCommand(SEARCH);
        btnBack.setActionCommand(EXIT);

    }

    /**
     * method that configures prompt text to the Swing components
     */

    private void configFields() {
        setDefaul();

        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtName.setText("");
                txtName.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDni.setText("");
                txtDni.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtFecNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFecNac.setText("");
                txtFecNac.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumber.setText("");
                txtNumber.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtAddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtAddress.setText("");
                txtAddress.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMail.setText("");
                txtMail.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

    }

    private void setDefaul() {
        txtIdClt.setText("Id");
        txtName.setText("Nombre completo");
        txtDni.setText("12345678A");
        txtFecNac.setText("00/00/0000");
        txtNumber.setText("123456789");
        txtAddress.setText("Calle, Avenida ...");
    }

    private void loadCmb() {
        cmbGender.setModel(dcbGender);
        dcbGender.removeAllElements();
        dcbGender.addElement("Género");
        dcbGender.addAll(List.of(GENDER_LIST));
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     * @param  c The controller to listen to the buttons
     */
    public void setController(Controller c) {
        btnSave.addActionListener(c);
        btnDelete.addActionListener(c);
        btnSearch.addActionListener(c);
        btnBack.addActionListener(c);
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
     * method that return a Cliente object according to the values
     * written in the form
     * @return Cliente object
     */

    public Cliente getClientInfo() {
        String nombre = txtName.getText();
        String dni = txtDni.getText();
        String fecNac = txtFecNac.getText();
        String sexo = (String) cmbGender.getSelectedItem();
        String tfl = txtNumber.getText();
        String dir = txtAddress.getText();
        String mail = txtMail.getText();
        Cliente c = new Cliente(dni, nombre, dir, fecNac, sexo, tfl, mail);
        return c;
    }

    /**
     * method that receives the complete information of a client
     * and display it
     * @param  c An objet of type Client
     */
    public void loadData(Cliente c){
        enableAll();
        txtName.setText(c.getNombre());
        txtDni.setText(c.getDni());
        txtFecNac.setText(c.getNacimiento());
        cmbGender.setSelectedItem(c.getSexo());
        txtNumber.setText(c.getTelefono());
        txtAddress.setText(c.getDireccion());
        txtMail.setText(c.getMail());
    }

    private void enableAll() {
        txtIdClt.setEnabled(false);
        txtName.setEnabled(true);
        txtDni.setEnabled(false);
        txtFecNac.setEnabled(true);
        cmbGender.setEnabled(true);
        txtNumber.setEnabled(true);
        txtAddress.setEnabled(true);
        txtMail.setEnabled(true);
    }

    /**
     * method that only allows to edit text area of the first JTextField
     * for the search and cleans the rest of the components
     */
    public void disableAllExceptTxtId() {
        txtIdClt.setEnabled(true);

        txtName.setText("");
        txtDni.setText("");
        txtFecNac.setText("");
        cmbGender.setSelectedIndex(0);
        txtNumber.setText("");
        txtAddress.setText("");
        txtMail.setText("");

        txtName.setEnabled(false);
        txtDni.setEnabled(false);
        txtFecNac.setEnabled(false);
        cmbGender.setEnabled(false);
        txtNumber.setEnabled(false);
        txtAddress.setEnabled(false);
        txtMail.setEnabled(false);
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

}
