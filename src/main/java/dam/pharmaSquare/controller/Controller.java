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
import dam.pharmaSquare.view.staff.VStaffMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller implements ActionListener {

    // Ventanas
    private VWindows vWindows;
    private VInicio vInicio;
    private VStaffLogin vStaffLogin;
    private VStaffMenu  vStaffMenu;
    private VCheckPersonal vCheckPersonal;
    private VSeeNoLogProducts vSeeNoLogProducts;
    private VSeeLoginProducts vSeeLoginProducts;
    private VAddCliente vAddCliente;
    private VAddPersonal vAddPersonal;
    private ArrayList<Personal> listaPersonal;
    private  Personal personal;
    private  String nombrePersonal;

    // Base de datos
    private PharmaSquareDB pharmaSquareDB;


    public Controller(VWindows vWindows, VInicio vInicio, VStaffLogin vStaffLogin, VStaffMenu vStaffMenu, VCheckPersonal vCheckPersonal, VSeeNoLogProducts vSeeNoLogProducts, VSeeLoginProducts vSeeLoginProducts, VAddCliente vAddCliente,VAddPersonal vAddPersonal, PharmaSquareDB pharmaSquareDB) {
        this.vWindows = vWindows;
        this.vInicio = vInicio;
        this.vStaffLogin = vStaffLogin;
        this.vStaffMenu = vStaffMenu;
        this.vCheckPersonal = vCheckPersonal;
        this.vSeeNoLogProducts = vSeeNoLogProducts;
        this.vSeeLoginProducts = vSeeLoginProducts;
        this.vAddCliente = vAddCliente;
        this.vAddPersonal = vAddPersonal;
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
            } else if (button == vAddCliente.getBtnCancel()) {
                vWindows.loadPanel(vInicio);
                vAddCliente.setDefault();
            } else if (button == vAddCliente.getBtnBorrar()) {
                vAddCliente.setDefault();
            } else if (button == vStaffLogin.getBtnBack()) {
                vWindows.loadPanel(vInicio);
                vStaffLogin.setDefault();
            } else if (button == vAddCliente.getBtnConfirmar()) {
                vAddCliente.addCliente();
                // TODO: Falta añadir la lógica de errores en caso de que no se pueda añadir el cliente
            } else if (e.getActionCommand().equals(VCheckPersonal.SEARCH)) {
                listaPersonal = pharmaSquareDB.getPersonal(vCheckPersonal.getComboBoxValue(), vCheckPersonal.getTextFieldValue());
                if (listaPersonal.size() < 1) {
                    JOptionPane.showMessageDialog(vInicio, "No se ha encontrado ningún personal según el criterio de busqueda introducido", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    vCheckPersonal.fillTable(listaPersonal);
                }
            } else if (e.getActionCommand().equals(VCheckPersonal.ADD_PERSONAL)) {
                vAddPersonal.refreshPanel();
                vWindows.loadPanel(vAddPersonal);
            } else if (e.getActionCommand().equals(VCheckPersonal.EDIT)) {
                personal = pharmaSquareDB.getPersonalbyName(vCheckPersonal.getTableRowPerName());
                vAddPersonal.modPersonal(personal);
                vWindows.loadPanel(vAddPersonal);
            } else if (e.getActionCommand().equals(VCheckPersonal.DELETE)) {
                nombrePersonal = vCheckPersonal.getTableRowPerName();
                int resp = JOptionPane.showConfirmDialog(vInicio, "¿Estas seguro que quieres eliminar el personal " + nombrePersonal + "?",
                        "Error", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    pharmaSquareDB.delPersonal(nombrePersonal);
                    vCheckPersonal.btnSearch.doClick();
                }
            } else if (e.getActionCommand().equals(VCheckPersonal.EXIT)) {
                vWindows.loadPanel(vStaffMenu);
            } else if (e.getActionCommand().equals(VAddPersonal.CONFIRM)) {
                int resp = JOptionPane.showConfirmDialog(vInicio, "Se añadirá el personal a lista ¿Está seguro?",
                        "Error", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                  //TODO INSERT PERSONAL INTO BBDD
                }
            } else if (e.getActionCommand().equals(VAddPersonal.MODIFY)) {
                int resp = JOptionPane.showConfirmDialog(vInicio, "¿Estas seguro que quieres modificar los datos del personal?",
                        "Error", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    personal = vAddPersonal.getPersonal();
                    pharmaSquareDB.modPersonal(personal);
                    vCheckPersonal.btnSearch.doClick();
                    vWindows.loadPanel(vCheckPersonal);
                }
            } else if (e.getActionCommand().equals(VAddPersonal.CONFIRM)) {
                System.out.println("hola2");
            } else if (e.getActionCommand().equals(VAddPersonal.CLEAN)) {
                vAddPersonal.cleanForm();
            } else if (e.getActionCommand().equals(VAddPersonal.EXIT)) {
                vWindows.loadPanel(vCheckPersonal);
            }
        }
    }
}
