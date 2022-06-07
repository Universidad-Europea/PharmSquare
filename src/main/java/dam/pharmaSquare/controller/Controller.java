package dam.pharmaSquare.controller;

import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.staff.VStaffLogin;
import dam.pharmaSquare.view.window.VWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    // Ventanas
    private VWindows vWindows;
    private VInicio vInicio;
    private VStaffLogin vStaffLogin;


    public Controller(VWindows vWindows, VInicio vInicio, VStaffLogin vStaffLogin) {
        this.vWindows = vWindows;
        this.vInicio = vInicio;
        this.vStaffLogin = vStaffLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals(vInicio.getBtnStaff().getText())) {
                vWindows.loadPanel(vStaffLogin);
            }
        }



    }
}
