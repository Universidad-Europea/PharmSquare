package dam.pharmaSquare.main;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting application");
//                View window = new View();

//                PharmaDB db = new PharmaDB();

//                Controller controller = new Controller(
//                    db
//                );
//                window.setController(controller);
//                window.setVisible(true);
            }
        });
    }
}