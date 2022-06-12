package dam.pharmaSquare.view.staff;

import dam.pharmaSquare.controller.Controller;

import javax.swing.*;

public class VStaffMenu extends JPanel {
    public static final String EXIT = "SALIR DE STAFF";
    public static final String ADD_MOD_PROD = "AÑADIR/MODIFICAR PRODUCTOS";
    public static final String ADD_MOD_CATEGORY = "AÑADIR/MODIFICAR CATEGORIAS";
    public static final String MOD_DELT_CLIENT = "MODIFICAR/ELIMINAR CLIENTES";
    public static final String VIEW_TRANSACTIONS = "VER TRANSACCIONES";
    public static final String MNG_PERSONAL = "GESTIONAR PERSONAL";

    public static final String VIEW_CLIENTS = "VER CLIENTES";

    private JPanel mainPanel;
    private JPanel panelProducts;
    private JPanel panelClients;
    private JPanel panelEmple;
    private JPanel jpTopElements;
    private JButton btnStaff;
    private JButton btnClock;
    private JLabel lblTitleProductos;
    private JButton btnAddModCategoria;
    private JButton btnAddModProducts;
    private JLabel lblClientesTitle;
    private JButton btnHistorialClientes;
    private JButton btnModDeltClient;
    private JButton btnGestionPersonal;
    private JLabel lblEmpleados;

    private JButton btnVerClientes;


    public VStaffMenu() {
        add(mainPanel);
        updateHour();
        init();
    }

    private void init() {
        btnStaff.setActionCommand(EXIT);
        btnAddModCategoria.setActionCommand(ADD_MOD_CATEGORY);
        btnAddModProducts.setActionCommand(ADD_MOD_PROD);
        btnModDeltClient.setActionCommand(MOD_DELT_CLIENT);
        btnHistorialClientes.setActionCommand(VIEW_TRANSACTIONS);
        btnGestionPersonal.setActionCommand(MNG_PERSONAL);

    }

    public void setController(Controller c) {
        btnStaff.addActionListener(c);
        btnAddModCategoria.addActionListener(c);
        btnAddModProducts.addActionListener(c);
        btnModDeltClient.addActionListener(c);
        btnHistorialClientes.addActionListener(c);
        btnGestionPersonal.addActionListener(c);
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
