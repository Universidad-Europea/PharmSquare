package dam.pharmaSquare.view.inicio;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.MessagesConfig;

import javax.swing.*;

public class VInicio extends JPanel {
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
    private static PharmaSquareDB db;

    public VInicio() {
        add(jpBody);
        configFields();
        updateHour();
    }

    public boolean validateLogin() {
        db = new PharmaSquareDB();
        return db.validPasswdCliente(txtfMail.getText(), new String(passwfPassword.getPassword()));
    }


    private void configFields() {
        setDefault();
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
        btnStaff.addActionListener(controller);
        btnSubmmit.addActionListener(controller);
        btnNewCliente.addActionListener(controller);
        btnNoLogin.addActionListener(controller);
    }

    public void setDefault() {
        txtfMail.setText("admin@uem.es");
        txtfMail.setForeground(new java.awt.Color(153, 153, 153));
        passwfPassword.setText("***********");
        passwfPassword.setForeground(new java.awt.Color(153, 153, 153));
    }

    public JButton getBtnNoLogin() {
        return btnNoLogin;
    }

    public JButton getBtnStaff() {
        return btnStaff;
    }

    public JButton getBtnNewCliente() {
        return btnNewCliente;
    }

    public JLabel getLblUsuario() {
        return lblUsuario;
    }

    public JLabel getLblPassword() {
        return lblPassword;
    }

    public JButton getBtnSubmmit() {
        return btnSubmmit;
    }
}
