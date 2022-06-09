package dam.pharmaSquare.view.category;

import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.*;
import javax.swing.*;

/**
 * <h1>VAddModCategory</h1>
 * The VAddModCategory implements a JPanel that
 * display all the available categories and allows
 * the user to edit the name of a selected category
 * or add a new one.
 * This panel is composed of Swing elements.
 */


public class VAddModCategory extends JPanel {
    /**
     * Import and declare Swing elements of VAddModCategory.form
     * with some final String that we are going to work with in
     * the following methods
     */
    private static final String CATEGORY_NAME = "NOMBRE";
    private static final String SAVE = "GUADAR DATOS";
    private static final String DELETE = "BORRAR";

    private JPanel jpBody;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JButton btnClock;
    private JPanel jpComponents;
    private JTable tblCtg;
    private JTextField txtNewCtgName;
    private JLabel lblNewCtg;
    private JLabel lblNewCtgNm;
    private JLabel lblModCtg;
    private JTextField textField1;
    private JLabel lblModCtgNm;
    private JButton btnSave;
    private static PharmaSquareDB db;


    public void VAddModCategory(){
        add(jpBody);
        loadDataTbl();
        updateHour();
    }

    public void updateHour() {

        btnClock.setText("00:00h");
        Timer timer = new Timer(1000, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClock.setText(getCurrentHour());
            }
        });
        timer.start();

    }

    private void loadDataTbl() {

    }

    private String getCurrentHour() {
        //Get hour and minutes from the system
        String hour = "";
        String minutes = "";

        hour = String.valueOf(java.time.LocalTime.now().getHour());
        minutes = String.valueOf(java.time.LocalTime.now().getMinute());

        if (hour.length() == 1) {
            hour = "0" + hour;
        } else {
            hour = hour;
        }

        if (minutes.length() == 1) {
            minutes = "0" + minutes;
        } else {
            minutes = minutes;
        }

        return hour + ":" + minutes + "h";
    }
}
