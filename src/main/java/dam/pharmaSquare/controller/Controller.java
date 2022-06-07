package dam.pharmaSquare.controller;

import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.window.VWindows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    // Ventanas
    private VWindows vWindows;


    public Controller(VWindows vWindows) {

        this.vWindows = vWindows;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            if (e.getActionCommand().equals(VCheckPersonal.EDIT)) {

            }
        }



    }
}
