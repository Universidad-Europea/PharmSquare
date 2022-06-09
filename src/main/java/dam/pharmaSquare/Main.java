package dam.pharmaSquare;

import com.formdev.flatlaf.FlatLightLaf;
import dam.dataValidation.BasicPasswordPolicy;
import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.view.addCliente.VAddCliente;
import dam.pharmaSquare.view.products.VSeeLoginProducts;
import dam.pharmaSquare.view.addPersonal.VAddPersonal;
import dam.pharmaSquare.view.consultarPersonal.VCheckPersonal;
import dam.pharmaSquare.view.inicio.VInicio;
import dam.pharmaSquare.view.products.VSeeNoLogProducts;
import dam.pharmaSquare.view.staff.VStaffLogin;
import dam.pharmaSquare.view.inicio.VWindows;
import dam.pharmaSquare.view.staff.VStaffMenu;

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
                VAddCliente vAddCliente = new VAddCliente();
                VCheckPersonal vCheckPersonal = new VCheckPersonal();
                VSeeLoginProducts vSeeLoginProducts = new VSeeLoginProducts();
                VSeeNoLogProducts vSeeNoLogProducts = new VSeeNoLogProducts();
                VStaffLogin vStaffLogin = new VStaffLogin();
                VStaffMenu vStaffMenu = new VStaffMenu();
                PharmaSquareDB pharmaSquareDB = new PharmaSquareDB();
                BasicPasswordPolicy policy = new BasicPasswordPolicy();

                Controller controller = new Controller(
                    vWindows,
                    vInicio,
                    vStaffLogin,
                    vStaffMenu,
                    vCheckPersonal,
                    vSeeNoLogProducts,
                    vSeeLoginProducts,
                    vAddCliente,
                    vAddPersonal,
                    pharmaSquareDB,
                    policy
                );

                vWindows.setVisible(true);
                vWindows.loadPanel(vInicio);
                vCheckPersonal.setController(controller);
                vAddPersonal.setController(controller);
                vInicio.setController(controller);
                vStaffLogin.setController(controller);
                vSeeLoginProducts.setController(controller);
                vSeeNoLogProducts.setController(controller);
                vAddCliente.setController(controller);
            }
        });
    }
}