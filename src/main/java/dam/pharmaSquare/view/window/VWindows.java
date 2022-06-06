package dam.pharmaSquare.view.window;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.model.MessagesConfig;

import javax.swing.*;
import java.awt.*;

public class VWindows extends JFrame {
    private JPanel jpBody;
    private JScrollPane jspContainer;
    private MessagesConfig msg;

    public VWindows() {
        configWindow();
        centerWindow();
        add(jpBody);
    }

    private void configWindow() {
        setTitle(msg.APP_NAME);
        setResizable(false);
        setSize(msg.WIDTH, msg.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void centerWindow() {
        setPreferredSize(new Dimension(msg.WIDTH, msg.HEIGHT));
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension ventana = this.getPreferredSize();
        setLocation((pantalla.width - ventana.width) / 2,  (pantalla.height - ventana.height) / 2);
    }

    public void setController(Controller controller) {

    }
}
