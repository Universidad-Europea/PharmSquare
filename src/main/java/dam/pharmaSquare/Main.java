package dam.pharmaSquare;

import com.formdev.flatlaf.FlatLightLaf;
import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.view.VSeeProducts;
import dam.pharmaSquare.view.addPersonal.VAddPersonal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.staff.VStaffLogin;
import dam.pharmaSquare.view.window.VWindows;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                VWindows vWindows = new VWindows();
                VInicio vInicio = new VInicio();
                VAddPersonal vAddPersonal = new VAddPersonal();
                VCheckPersonal vCheckPersonal = new VCheckPersonal();
                VSeeProducts vSeeProducts = new VSeeProducts();
                VStaffLogin vStaffLogin = new VStaffLogin();

//                PharmaDB db = new PharmaDB();

                Controller controller = new Controller(
                    vWindows,
                    vInicio,
                    vStaffLogin
                );
                vWindows.setVisible(true);
                vWindows.loadPanel(vInicio);
                vCheckPersonal.setController(controller);
                vInicio.setController(controller);
                vStaffLogin.setController(controller);
            }
        });
    }
}