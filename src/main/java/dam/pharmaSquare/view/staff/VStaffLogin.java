package dam.pharmaSquare.view.staff;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.MessagesConfig;

import javax.swing.*;

public class VStaffLogin extends JPanel {
    private JPanel jpBody;
    private JPanel jpForm;
    private JPanel jpTopElements;
    private JLabel lblTime;
    private JButton btnStaff;
    private JLabel lblTitle;
    private JTextField txtfMail;
    private JPasswordField passwfPassword;
    private JButton btnSubmmit;
    private JButton btnNewCliente;
    private JButton btnNoLogin;
    private JLabel lblUsuario;
    private JLabel lblPassword;
    private JButton btnClock;
    private MessagesConfig msg;

    public VStaffLogin() {
        add(jpBody);
        updateHour();
        configFields();

    }

    private void configFields() {
        txtfMail.setText("DNI");
        txtfMail.setForeground(new java.awt.Color(153, 153, 153));
        passwfPassword.setText("Contraseña");
        passwfPassword.setForeground(new java.awt.Color(153, 153, 153));
        txtfMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtfMail.setText("");
                txtfMail.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        passwfPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwfPassword.setText("");
                passwfPassword.setForeground(new java.awt.Color(0, 0, 0));
            }
        });
    }

    public void updateHour() {

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

    public void setController(Controller controller) {
        btnStaff.addActionListener(controller);
        btnSubmmit.addActionListener(controller);
    }
}