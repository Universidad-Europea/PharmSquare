package dam.pharmaSquare.view.consultProducts;

import javax.swing.*;

public class VConsultProducts {
    private  JPanel jpBody;
    private JPanel jpTopElements;
    private JButton btnBack;
    private JButton btnClock;
    private JLabel lblTitle;
    private JPanel jpTable;
    private JTextField txtProducts;
    private JTable tblProducts;
    private JButton btnSearch;
    private JButton btnNewProd;
    private JButton btnEditProd;
    private JButton btnDeleteProd;


    public VConsultProducts() {
        init();
        updateHour();
    }
    private void init() {

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
