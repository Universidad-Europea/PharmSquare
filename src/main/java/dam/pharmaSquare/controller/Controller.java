package dam.pharmaSquare.controller;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.view.addCliente.VAddCliente;
import dam.pharmaSquare.view.addPersonal.VAddPersonal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.products.VSeeLoginProducts;
import dam.pharmaSquare.view.products.VSeeNoLogProducts;
import dam.pharmaSquare.view.staff.VStaffLogin;
import dam.pharmaSquare.view.inicio.VWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

    // Ventanas
    private VWindows vWindows;
    private VInicio vInicio;
    private VStaffLogin vStaffLogin;
    private VCheckPersonal vCheckPersonal;
    private VSeeNoLogProducts vSeeNoLogProducts;
    private VSeeLoginProducts vSeeLoginProducts;
    private VAddCliente vAddCliente;
    private ArrayList<Personal> listaPersonal;

    // Base de datos
    private PharmaSquareDB pharmaSquareDB;


    public Controller(VWindows vWindows, VInicio vInicio, VStaffLogin vStaffLogin, VCheckPersonal vCheckPersonal, VSeeNoLogProducts vSeeNoLogProducts, VSeeLoginProducts vSeeLoginProducts, VAddCliente vAddCliente, PharmaSquareDB pharmaSquareDB) {
        this.vWindows = vWindows;
        this.vInicio = vInicio;
        this.vStaffLogin = vStaffLogin;
        this.vCheckPersonal = vCheckPersonal;
        this.vSeeNoLogProducts = vSeeNoLogProducts;
        this.vSeeLoginProducts = vSeeLoginProducts;
        this.vAddCliente = vAddCliente;
        this.pharmaSquareDB = pharmaSquareDB;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == vInicio.getBtnStaff()) {
                vWindows.loadPanel(vStaffLogin);
                vInicio.setDefault();
            } else if (button == vSeeLoginProducts.getBtnExit()) {
                vWindows.loadPanel(vInicio);
                vStaffLogin.setDefault();
            } else if (button == vSeeNoLogProducts.getBtnExit()) {
                vWindows.loadPanel(vInicio);
            } else if (button == vInicio.getBtnNoLogin()) {
                vWindows.loadPanel(vSeeNoLogProducts);
                vInicio.setDefault();
            } else if (button == vInicio.getBtnNewCliente()) {
                vWindows.loadPanel(vAddCliente);
            } else if (button == vInicio.getBtnSubmmit() && vInicio.validateLogin() == true) {
                vWindows.loadPanel(vSeeLoginProducts);
                vInicio.setDefault();
            } else if (button == vInicio.getBtnSubmmit() && vInicio.validateLogin() == false) {
                JOptionPane.showMessageDialog(vInicio, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                vInicio.setDefault();
            } else if (button == vStaffLogin.getBtnSubmmit() && vStaffLogin.validateLogin() == true) {
                // TODO: Login correcto, panel de staff sin hacer
                System.out.println("[LOG] Login correcto");
            } else if (button == vStaffLogin.getBtnSubmmit() && vStaffLogin.validateLogin() == false) {
                JOptionPane.showMessageDialog(vInicio, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                vStaffLogin.setDefault();
            } else if (button == vStaffLogin.getBtnBack()) {
                vWindows.loadPanel(vInicio);
                vStaffLogin.setDefault();
            } else if (e.getActionCommand().equals(VCheckPersonal.SEARCH)) {
                listaPersonal = pharmaSquareDB.getPersonal(vCheckPersonal.getComboBoxValue());
                vCheckPersonal.fillTable(listaPersonal);
            }

        }
    }
}
