package dam.pharmaSquare.view.addCliente;


import dam.pharmaSquare.controller.Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VAddCliente extends JPanel {
    private JPanel jpBody;
    private JPanel jpElements;
    private JButton btnExit;
    private JButton btnAddPer;
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
        btnExit.addActionListener(controller);
        btnAddPer.addActionListener(controller);
    }
}
