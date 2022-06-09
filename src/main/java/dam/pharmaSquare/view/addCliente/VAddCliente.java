package dam.pharmaSquare.view.addCliente;

import dam.dataValidation.DataValidation;
import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class VAddCliente extends JPanel {
    private JPanel jpBody;
    private JPanel jpElements;
    private JButton btnClock;
    private JButton btnCancel;
    private JLabel lblTitle;
    private JPanel jpForm;
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtFechaNac;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JButton btnConfirmar;
    private JButton btnBorrar;
    private JRadioButton rdbtMasculino;
    private JRadioButton rdbtFemenino;
    private JLabel lblDNI;
    private JTextField txtdni;
    private JLabel lblNombre;
    private JLabel lblDirect;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JLabel lblFechaNac;
    private JLabel lblMail;
    private JPasswordField txtPassword;
    private JLabel lblPassword;
    private static PharmaSquareDB db;

    public VAddCliente() {
        add(jpBody);
        updateHour();
        configFields();
    }

    public void addCliente() {

    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = new java.util.Date();
    db = new PharmaSquareDB();

    String dni = txtdni.getText();
    String nombre = txtNombre.getText();
    String fAlta = dateFormat.format(date); // Fecha de alta
    String direccion = txtDireccion.getText();
    String fechaNac = txtFechaNac.getText();
    String password = txtPassword.getText();
    String sexo = "";
    if (rdbtMasculino.isSelected()) {
        sexo = "M";
    } else {
        sexo = "F";
    }
    String telefono = txtTelefono.getText();

    String mail = txtMail.getText();

        db.addCliente(new Cliente(
                dni,
                nombre,
                fAlta,
                direccion,
                fechaNac,
                password,
                sexo,
                telefono,
                mail
        ));

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

    private void configFields() {
        setDefault();

        txtdni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdni.setText("");
                txtdni.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre.setText("");
                txtNombre.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccion.setText("");
                txtDireccion.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtFechaNac.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaNac.setText("");
                txtFechaNac.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefono.setText("");
                txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
            }
        });

        txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMail.setText("");
                txtMail.setForeground(new java.awt.Color(0, 0, 0));
            }
        });
    }

    public void setDefault() {
        txtdni.setText("Introduzca su DNI");
        txtdni.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Introduzca su nombre");
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtDireccion.setText("Introduzca su dirección");
        txtDireccion.setForeground(new java.awt.Color(153, 153, 153));
        txtFechaNac.setText("Introduzca su fecha de nacimiento");
        txtFechaNac.setForeground(new java.awt.Color(153, 153, 153));
        txtTelefono.setText("Introduzca su teléfono");
        txtTelefono.setForeground(new java.awt.Color(153, 153, 153));
        txtMail.setText("Introduzca su mail");
        txtMail.setForeground(new java.awt.Color(153, 153, 153));
        rdbtMasculino.setSelected(true);
    }

    public void setController(Controller controller) {
        btnCancel.addActionListener(controller);
        btnConfirmar.addActionListener(controller);
        btnBorrar.addActionListener(controller);
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }

    public JButton getBtnConfirmar() {
        return btnConfirmar;
    }
}
