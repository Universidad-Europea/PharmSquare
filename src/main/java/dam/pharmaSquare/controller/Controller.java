package dam.pharmaSquare.controller;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.staff.VStaffLogin;
import dam.pharmaSquare.view.window.VWindows;

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
    private ArrayList<Personal> listaPersonal;

    // Base de datos
    private PharmaSquareDB pharmaSquareDB;


    public Controller(VWindows vWindows, VInicio vInicio, VStaffLogin vStaffLogin, VCheckPersonal vCheckPersonal) {
        this.vWindows = vWindows;
        this.vInicio = vInicio;
        this.vStaffLogin = vStaffLogin;
        this.vCheckPersonal = vCheckPersonal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();

            if (button == vInicio.getBtnStaff()) {
                vWindows.loadPanel(vStaffLogin);
                vInicio.setDefault();
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
