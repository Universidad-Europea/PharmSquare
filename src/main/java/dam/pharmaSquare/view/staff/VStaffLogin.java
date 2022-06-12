package dam.pharmaSquare.view.staff;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.MessagesConfig;

import javax.swing.*;

public class VStaffLogin extends JPanel {
    private JPanel jpBody;
    private JPanel jpForm;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JLabel lblTitle;
    private JTextField txtDNI;
    private JPasswordField btnPassword;
    private JButton btnSubmmit;
    private JLabel lblUsuario;
    private JLabel lblPassword;
    private JButton btnClock;
    private static PharmaSquareDB db;

    public VStaffLogin() {
        add(jpBody);
        updateHour();
        configFields();
    }

    private void configFields() {
        setDefault();
        txtDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDNI.setText("");
                txtDNI.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        btnPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnPassword.setText("");
                btnPassword.setForeground(new java.awt.Color(0, 0, 0));
            }
        });
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
        btnBack.addActionListener(controller);
        btnSubmmit.addActionListener(controller);
    }

    public boolean validateLogin() {
        db = new PharmaSquareDB();
        boolean valid = false;

        if (db.validPasswdPersonal(txtDNI.getText(), btnPassword.getText())) {
            valid = true;
        } else {
            valid = false;
        }

        return valid;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnSubmmit() {
        return btnSubmmit;
    }

    public void setDefault() {
        txtDNI.setText("123456789D");
        txtDNI.setForeground(new java.awt.Color(153, 153, 153));
        btnPassword.setText("***********");
        btnPassword.setForeground(new java.awt.Color(153, 153, 153));
    }

}