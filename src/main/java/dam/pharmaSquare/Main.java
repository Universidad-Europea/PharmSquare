package dam.pharmaSquare;

import com.formdev.flatlaf.FlatLightLaf;
import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.view.VSeeProducts;
import dam.pharmaSquare.view.addPersonal.VAddPersonal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
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
                VAddPersonal vAddPersonal = new VAddPersonal();
                VCheckPersonal vCheckPersonal = new VCheckPersonal();
                VSeeProducts vSeeProducts = new VSeeProducts();

//                PharmaDB db = new PharmaDB();

                Controller controller = new Controller(
                    vWindows
                );
                vWindows.setVisible(true);
                vWindows.loadPanel(vCheckPersonal);
                vCheckPersonal.setController(controller);
            }
        });
    }
}