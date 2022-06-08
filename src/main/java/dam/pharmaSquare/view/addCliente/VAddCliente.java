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
    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtFechaNac;
    private JTextField txtTelefono;
    private JTextField txtMail;
    private JButton btnConfirmar;
    private JButton btnBorrar;
    private JRadioButton rdbtEmpleado;
    private JRadioButton rdbtAdministrativo;
    private JLabel lblDNI;
    private JTextField txtfMail;
    private JLabel lblNombre;
    private JLabel lblDirect;
    private JLabel lblTelefono;
    private JLabel lblSexo;
    private JLabel lblFechaNac;
    private JLabel lblMail;

    public VAddCliente() {
        add(jpBody);
    }

    public void setController(Controller controller) {
        btnCancel.addActionListener(controller);
        btnConfirmar.addActionListener(controller);
        btnBorrar.addActionListener(controller);
    }
}
