package dam.pharmaSquare.controller;

import dam.dataValidation.DataValidation;
import dam.exception.InvalidDataException;
import dam.dataValidation.BasicPasswordPolicy;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Cliente;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.view.cliente.VAddCliente;
import dam.pharmaSquare.view.category.VAddModCategory;
import dam.pharmaSquare.view.cliente.VModClient;
import dam.pharmaSquare.view.personal.VAddPersonal;
import dam.pharmaSquare.view.personal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.products.VModifyProducts;
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
    private VModifyProducts vModifyProducts;
    private VAddModCategory vAddModCategory;
    private VModClient vModClient;
    private ArrayList<Personal> listaPersonal;
    private  Personal personal;
    private  String nombrePersonal;

    // Base de datos
    private PharmaSquareDB pharmaSquareDB;

    // Validación de datos
    private  BasicPasswordPolicy policy;

    private  String error = "";
    private int editMode = 0;


    public Controller(VWindows vWindows, VInicio vInicio, VStaffLogin vStaffLogin, VStaffMenu vStaffMenu, VCheckPersonal vCheckPersonal, VSeeNoLogProducts vSeeNoLogProducts, VSeeLoginProducts vSeeLoginProducts, VAddCliente vAddCliente, VAddPersonal vAddPersonal, VModifyProducts vModifyProducts, VAddModCategory vAddModCategory, VModClient vModClient, PharmaSquareDB pharmaSquareDB, BasicPasswordPolicy policy) {
        this.vWindows = vWindows;
        this.vInicio = vInicio;
        this.vStaffLogin = vStaffLogin;
        this.vStaffMenu = vStaffMenu;
        this.vCheckPersonal = vCheckPersonal;
        this.vSeeNoLogProducts = vSeeNoLogProducts;
        this.vSeeLoginProducts = vSeeLoginProducts;
        this.vAddCliente = vAddCliente;
        this.vAddPersonal = vAddPersonal;
        this.vModifyProducts = vModifyProducts;
        this.vAddModCategory = vAddModCategory;
        this.vModClient = vModClient;
        this.pharmaSquareDB = pharmaSquareDB;
        this.policy = policy;
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
            } else if (button == vModifyProducts.getBtnEliminar()) {
                vModifyProducts.eliminarSeleccion();
            } else if (button == vModifyProducts.getBtnModificar()) {
                editMode ++;
                vModifyProducts.editMode(editMode);
            } else if (button == vModifyProducts.getBtnGuardar()) {
                vModifyProducts.updateProductDB();
            } else if (button == vAddCliente.getBtnConfirmar()) {
                try {
                    vAddCliente.addCliente();
                    JOptionPane.showMessageDialog(vAddCliente, "Cliente añadido correctamente", "Añadido", JOptionPane.INFORMATION_MESSAGE);
                } catch (InvalidDataException ex) {
                    error = ex.getMessage();
                    JOptionPane.showMessageDialog(vAddCliente, error, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else if (e.getActionCommand().equals(VCheckPersonal.SEARCH)) {
                listaPersonal = pharmaSquareDB.getPersonal(vCheckPersonal.getComboBoxValue(), vCheckPersonal.getTextFieldValue());
                if (listaPersonal.size() < 1) {
                    JOptionPane.showMessageDialog(vInicio, "No se ha encontrado ningún personal según el criterio de busqueda introducido", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    vCheckPersonal.fillTable(listaPersonal);
                }
            } else if (e.getActionCommand().equals(VCheckPersonal.ADD_PERSONAL)) {
                vAddPersonal.layoutAddPersonal();
                vWindows.loadPanel(vAddPersonal);
            } else if (e.getActionCommand().equals(VCheckPersonal.EDIT)) {
                personal = pharmaSquareDB.getPersonalbyName(vCheckPersonal.getTableRowPerName());
                vAddPersonal.layoutModPersonal(personal);
                vWindows.loadPanel(vAddPersonal);
            } else if (e.getActionCommand().equals(VCheckPersonal.DELETE)) {
                nombrePersonal = vCheckPersonal.getTableRowPerName();
                int resp = JOptionPane.showConfirmDialog(vInicio, "¿Estás seguro que quieres eliminar el personal " + nombrePersonal + "?",
                        "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    pharmaSquareDB.delPersonal(nombrePersonal);
                    vCheckPersonal.btnSearch.doClick();
                }
            } else if (e.getActionCommand().equals(VCheckPersonal.EXIT)) {
                vWindows.loadPanel(vStaffMenu);
            } else if (e.getActionCommand().equals(VAddPersonal.CONFIRM)) {
                int resp = JOptionPane.showConfirmDialog(vInicio, "Se añadirá el personal a lista ¿Está seguro?",
                        "Confirmar añadir personal", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    try {
                        personal = vAddPersonal.getPersonal();
                        policy.validate(personal.getPasswd(), personal.getNombre());
                        pharmaSquareDB.addPersonal(personal);
                        vCheckPersonal.btnSearch.doClick();
                        vWindows.loadPanel(vCheckPersonal);
                    } catch (InvalidDataException ex) {
                        error = ex.getMessage();
                        JOptionPane.showMessageDialog(vInicio, error, "Error", JOptionPane.ERROR_MESSAGE);

                    }
                }
            } else if (e.getActionCommand().equals(VAddPersonal.MODIFY)) {
                int resp = JOptionPane.showConfirmDialog(vInicio, "¿Estás seguro que quieres modificar los datos del personal?",
                        "Confirmar modificar personal", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    try {
                        personal = vAddPersonal.getPersonal();
                        policy.validate(personal.getPasswd(), personal.getNombre());
                        pharmaSquareDB.modPersonal(personal);
                        vCheckPersonal.btnSearch.doClick();
                        vWindows.loadPanel(vCheckPersonal);
                    } catch (InvalidDataException ex) {
                        error = ex.getMessage();
                        JOptionPane.showMessageDialog(vInicio, error, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else if (e.getActionCommand().equals(VAddPersonal.CLEAN)) {
                vAddPersonal.cleanForm();
            } else if (e.getActionCommand().equals(VAddPersonal.EXIT)) {
                vWindows.loadPanel(vCheckPersonal);
            } else if (e.getActionCommand().equals(VModClient.SEARCH)) {
                vModClient.loadData(pharmaSquareDB.getCliente(vModClient.,vModClient.getTextFieldValue()));
            } else if (e.getActionCommand().equals(VModClient.DELETE)) {
                int resp = JOptionPane.showConfirmDialog(vModClient, "¿Estás seguro que quieres eliminar a este cliente?",
                        "Confirmar borrado", JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    int res = pharmaSquareDB.delCliente(vModClient.,vModClient.getTextFieldValue());
                    if (res > 1){
                        JOptionPane.showMessageDialog(vModClient, "Se ha eliminado al cliente",
                                "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                        vModClient.disableAllExceptTxtId();
                    } else {
                        JOptionPane.showMessageDialog(vModClient, "No se han podido eliminar al cliente",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            } else if (e.getActionCommand().equals(VModClient.SAVE)) {
                Cliente cliente = vModClient.getClientInfo();
                if(cliente != null) {
                    int resp = JOptionPane.showConfirmDialog(vModClient, "¿Estás seguro que quieres modificar la" +
                                    " información de este cliente?",
                            "Confirmar modificar ciente", JOptionPane.YES_NO_OPTION);
                    if (resp == 0) {
                        int res = pharmaSquareDB.modCliente(cliente);

                        if (res > 1) {
                            JOptionPane.showMessageDialog(vModClient, "Se han modificado los datos del cliente",
                                    "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                            vModClient.disableAllExceptTxtId();
                        } else {
                            JOptionPane.showMessageDialog(vModClient, "No se han podido modificar los datos del cliente",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }  else if (e.getActionCommand().equals(VModClient.EXIT)) {
                vWindows.loadPanel(vStaffMenu);
            }
        }
    }
}
