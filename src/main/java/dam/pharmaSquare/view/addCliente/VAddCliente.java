package dam.pharmaSquare.view.addCliente;

import dam.pharmaSquare.controller.Controller;

import javax.swing.*;

public class VAddCliente extends JPanel {
    private JPanel jpBody;
    private JPanel jpElements;
    private JButton btnClock;
    private JButton btnCancel;
    private JLabel lblTitle;
    private JPanel jpForm;
    private JLabel lblDNI;
    private JTextField txtDNI;
    private JLabel lblNombre;
    private JTextField txtNombre;
    private JLabel lblDireccion;
    private JTextField txtDireccion;
    private JLabel lblFachaNac;
    private JTextField txtFechaNac;
    private JLabel lblSexo;
    private JLabel lblTelefono;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JLabel lblMail;
    private JButton btnConfirmar;
    private JButton btnBorrar;
    private JRadioButton rdbtEmpleado;
    private JRadioButton rdbtAdministrativo;

    public VAddCliente() {
        add(jpBody);
    }

    public void setController(Controller controller) {
        btnCancel.addActionListener(controller);
        btnConfirmar.addActionListener(controller);
        btnBorrar.addActionListener(controller);
    }
}
