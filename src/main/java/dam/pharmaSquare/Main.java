package dam.pharmaSquare;

import com.formdev.flatlaf.FlatLightLaf;
import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.view.addPersonal.VaddPersonal;
import dam.pharmaSquare.view.consultarPersonal.VconsultarPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
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
                System.out.println("Starting application");
                VWindows vWindows = new VWindows();
                VInicio vInicio = new VInicio();
                VaddPersonal vaddPersonal = new VaddPersonal();
                VconsultarPersonal vconsultarPersonal = new VconsultarPersonal();

//                PharmaDB db = new PharmaDB();

                Controller controller = new Controller(
                    vWindows
                );
                vWindows.setVisible(true);
                vWindows.loadPanel(vconsultarPersonal);
            }
        });
    }
}