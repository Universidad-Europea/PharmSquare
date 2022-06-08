package dam.pharmaSquare.view.addPersonal;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.view.inicio.VInicio;

import javax.swing.*;

public class VAddPersonal extends JPanel {
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
    private  JRadioButton rdbtAdministrativo;
    private JPanel jpElements;
    private  JButton btnCancel;
    private  JLabel lblTitle;
    private JButton btnBorrar;
    private JButton btnClock;

    public VAddPersonal() {
        add(jpBody);
        init();
        updateHour();
    }

    private void init() {
        // add addActionCommand to the buttons to be able to control the button in the controller class
        btnConfirmar.setActionCommand(CONFIRM);
        btnBorrar.setActionCommand(CLEAN);
        btnCancel.setActionCommand(EXIT);
    }

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

    public  void modPersonal(Personal personal) {
        lblTitle.setText("Modificar Personal");
        txtfNombre.setText(personal.getNombre());
        String categoria = personal.getCategoria();
        if (categoria.equals("EMPLEADO")) {
            rdbtEmpleado .doClick();
        }else {
            rdbtAdministrativo.doClick();
        }

        txtFDni.setText(personal.getDni());
        pwd.setText(personal.getPasswd());
        btnConfirmar.setText("Modificar");
        btnConfirmar.setActionCommand(MODIFY);

    }

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