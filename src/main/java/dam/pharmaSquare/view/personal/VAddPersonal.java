package dam.pharmaSquare.view.personal;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.Personal;

import javax.swing.*;

/**
 * <h1>VAddPersonal</h1>
 * The VAddPersonal  implements a JPanel that
 * display a form and allows insert staff
 * this JPanel is composed of Swing elements
 */
public class VAddPersonal extends JPanel {
    /**
     * Import Swing elements of VAddPersonal.form and declares them,
     * also initialize some final String used in bellow methods
     */
    public static final String CONFIRM = "CONFIRMAR";
    public static final String MODIFY = "MODIFICAR";
    public static final String CLEAN = "LIMPIAR";
    public static final String EXIT = "VOLVER A VCHECKPERSONAL";

    private  JPanel jpBody;
    private JPanel jpForm;
    private JTextField txtFDni;
    private JLabel lblPassword;
    private JLabel lblCategoria;
    private JLabel lblDni;
    private JLabel lblNombre;
    private JTextField txtfNombre;
    private JRadioButton rdbtEmpleado;
    private  JPasswordField pwd;
    private  JButton btnConfirmar;
    private  JRadioButton rdbtAdministrador;
    private JPanel jpElements;
    private  JButton btnCancel;
    private  JLabel lblTitle;
    private JButton btnBorrar;
    private JButton btnClock;

    /**
     * method calling private methods
     *
     * - add(jpBody)
     * @param jpBody This is the Jpanel how contains all the swing elements
     * @return the component argument
     */
    public VAddPersonal() {
        add(jpBody);
        init();
        updateHour();
    }
    /**
     * method that initializes the Swing components
     */
    private void init() {
        // add addActionCommand to the buttons to be able to control the button in the controller class
        btnConfirmar.setActionCommand(CONFIRM);
        btnBorrar.setActionCommand(CLEAN);
        btnCancel.setActionCommand(EXIT);
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     * @param  c The controller to listen to the buttons
     */
    public void setController(Controller c) {

        btnConfirmar.addActionListener(c);
        btnBorrar.addActionListener(c);
        btnCancel.addActionListener(c);
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
    /**
     * method that receives a Personal object and show it into the form
     * also change the JPanel layout
     * @param  personal The Personal objecto to display
     */
    public  void layoutModPersonal(Personal personal) {
        lblTitle.setText("Modificar Personal");
        txtfNombre.setText(personal.getNombre());
        String categoria = personal.getCategoria();
        if (categoria.equals("EMPLEADO")) {
            rdbtEmpleado .doClick();
        }else {
            rdbtAdministrador.doClick();
        }

        txtFDni.setText(personal.getDni());
        pwd.setText(personal.getPasswd());
        btnConfirmar.setText("Modificar");
        btnConfirmar.setActionCommand(MODIFY);

    }

    /**
     Change the JPanel layout
     */
    public void layoutAddPersonal() {
        lblTitle.setText("Añadir Personal");
        txtfNombre.setText("");
        txtFDni.setText("");
        pwd.setText("");
        rdbtEmpleado.doClick();
        btnConfirmar.setText("Confirmar");
        btnConfirmar.setActionCommand(CONFIRM);
    }

    /**
     *  method that return a Personal object according to the values
     *  written in the form
     *  @return  nombre JTable row value
     */
    public  Personal getPersonal() {
        String dni = txtFDni.getText();
        String nombre = txtfNombre.getText();
        String categoria;
        if (rdbtEmpleado.isSelected()) {
            categoria = "EMPLEADO";
        } else {
            categoria = "ADMINISTRATIVO";
        }
        String password = pwd.getText();

        Personal p = new Personal(dni, nombre, categoria, password);
        return  p;
    }

    /**
     * methot that empties the form fields
     */
    public void cleanForm() {
        txtfNombre.setText("");
        txtFDni.setText("");
        pwd.setText("");
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