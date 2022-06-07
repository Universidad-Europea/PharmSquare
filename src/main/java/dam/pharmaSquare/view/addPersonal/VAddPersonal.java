package dam.pharmaSquare.view.addPersonal;

import dam.pharmaSquare.view.inicio.VInicio;

import javax.swing.*;

public class VAddPersonal extends JPanel {

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
        updateHour();
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
