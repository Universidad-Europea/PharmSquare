package dam.pharmaSquare.view.window;

import dam.pharmaSquare.controller.Controller;

import javax.swing.*;

public class VWindows extends JFrame {
    private JPanel jpBody;
    private JScrollPane jspContainer;

    public VWindows() {
        setTitle("PharmaSquare");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        add(jpBody);
    }

    public void setController(Controller controller) {

    }
}
