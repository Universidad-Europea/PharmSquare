package dam.pharmaSquare.view.consultarPersonal;

import dam.pharmaSquare.controller.Controller;
import dam.pharmaSquare.db.PharmaSquareDB;
import dam.pharmaSquare.model.Personal;
import dam.pharmaSquare.model.persistencia.PPersonal;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

/**
 * <h1>VconsultarPersonal</h1>
 * The VconsultarPersonal  implements a JPanel that
 * display the staff and can delete and edit them,
 * this JPanel is composed of swing elements
 */
public class VCheckPersonal extends JPanel {
    /**
     * Import Swing elements of VconsultarPersonal.form and declares them,
     * also initialize some final String used in bellow methods
     */
    private static final String LASTNAME = "APELLIDO";
    public static final String EDIT = "EDITAR";
    public static final String DELETE = "BORRAR";
    public static final String SEARCH = "BUSCAR";
    public static final String EXIT = "SALIR";
    public static final String ADD_PERSONAL = "AÑADIR PERSONAL";

    private JPanel jpBody;
    private JPanel jpElements;
    private JButton btnExit;
    private JPanel jpTable;
    private JScrollPane scrpTable;
    private JTable tablePer;
    private JComboBox cmbOrder;
    private JTextField txtSearchName;
    private JButton btnAddPer;
    private JButton btnSearch;
    private JButton btnClock;
    private DefaultTableModel dtmPer;
    private  ButtonRenderer btnEdit;
    private  ButtonRenderer btnDelt;

    public VCheckPersonal() {
        /**
         * method calling private methods
         *
         * - add(jpBody)
         * @param jpBody This is the Jpanel how contains all the swing elements
         * @return the component argument
         */
        init();
        add(jpBody);
        updateHour();
    }

    /**
     * method that initializes the swing components
     */
    private void init() {

        // specify the scrollable child that's going to be displayed in the scrollpane
        scrpTable.setViewportView(tablePer);

        //  add Array of String that contain the multiple options
        cmbOrder.setModel(new DefaultComboBoxModel<String> (PharmaSquareDB.PERSONAL_FILTERS));

        configTable();
    }

    /**
     * Configure the JTable by adding specific columns
     * @return nothing
     */
    private void configTable() {

        // addMouseListener to be able to click  the icons buttons  (btnEdit & btnDelt)
        // according to the cell clicked
        tablePer.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tablePer.rowAtPoint(evt.getPoint());
                int col = tablePer.columnAtPoint(evt.getPoint());
               if (col == 3) {
                   btnEdit.doClick();
               } else if (col == 4) {
                   btnDelt.doClick();
               }
            }
        });
        // initialize DefaultTableCellRenderer
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        // declare ButtonRenderer
        btnEdit = new ButtonRenderer(EDIT);
        btnEdit.setActionCommand(EDIT);
        btnDelt = new ButtonRenderer(DELETE);

        // add addActionCommand to the buttons to be able to control the button in the controller class
        btnEdit.setActionCommand(EDIT);
        btnDelt.setActionCommand(DELETE);
        btnSearch.setActionCommand(SEARCH);
        btnExit.setActionCommand(EXIT);
        btnAddPer.setActionCommand(ADD_PERSONAL);

        // declare DefaultTableModel and disable cell editing
        dtmPer = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }
        } ;

        // set the defaultTableModel to the JTable
        tablePer.setModel(dtmPer);

        //Adding table columns
        dtmPer.addColumn(PPersonal.CATEGORIA);
        dtmPer.addColumn(PPersonal.NOMBRE);
        dtmPer.addColumn(LASTNAME);
        dtmPer.addColumn(EDIT);
        dtmPer.addColumn(DELETE);

        //Setting table columns
        tablePer.getColumn(PPersonal.CATEGORIA).setPreferredWidth(30);
        tablePer.getColumn(PPersonal.CATEGORIA).setCellRenderer(centerRenderer);
        tablePer.getColumn(PPersonal.NOMBRE).setPreferredWidth(20);
        tablePer.getColumn(PPersonal.NOMBRE).setCellRenderer(centerRenderer);
        tablePer.getColumn(LASTNAME).setPreferredWidth(200);
        tablePer.getColumn(LASTNAME).setCellRenderer(centerRenderer);

        // Setting table columns implementing the created ButtonRenderer
        tablePer.getColumn(EDIT).setPreferredWidth(10);
        tablePer.getColumn(EDIT).setCellRenderer(btnEdit);
        tablePer.getColumn(DELETE).setPreferredWidth(10);
        tablePer.getColumn(DELETE).setCellRenderer(btnDelt);

        tablePer.setRowHeight(30);
    }

    /**
     * method that receives a controller and applies it to the elements to be heard
     */
    public void setController(Controller c) {

        btnDelt.addActionListener(c);
        btnEdit.addActionListener(c);
        btnExit.addActionListener(c);
        btnAddPer.addActionListener(c);
        btnSearch.addActionListener(c);
    }

    /**
     * method that return a String with the value of the JComboBox
     */

    public String getComboBoxValue(){
        String type = (String) cmbOrder.getSelectedItem();
        return  type;
    }

    /**
     * This method fill the table adding rows
     * @return nothing
     */
    public void fillTable(ArrayList<Personal> listaPersonal) {

        Object[] fila = new Object[5];

        for (Personal personal: listaPersonal) {
            fila[0] = personal.getCategoria();
            int idx = personal.getNombre().indexOf(' ');
            String nombre = personal.getNombre().substring(0, idx);
            String apellido  = personal.getNombre().substring(idx + 1);
            fila[1] = nombre;
            fila[2] = apellido;

            dtmPer.addRow(fila);
        }



    }



    class ButtonRenderer extends JButton implements TableCellRenderer {
        /**
         * implements a ButtonRenderer which is inserted inside the JTable
         * @param icon this is a String how tell to the ButtonRender method which image to use
         * @return nothing
         */

        /**
         * this method edits the layout of the button and applies an icon to it
         * @return nothing
         * @exception Exception is trowed if the image is not founded in the resource folder
         */
        public ButtonRenderer(String icon) {
            setOpaque(true);
            setBorderPainted(false);

            try {
                if (icon == EDIT) {
                    Image img = ImageIO.read(getClass().getResource("/img/buttons/edit.png"));
                    setIcon(new ImageIcon(img));
                } else {
                    Image img = ImageIO.read(getClass().getResource("/img/buttons/delete.png"));
                    setIcon(new ImageIcon(img));
                }
            }catch (Exception ex) {
                System.out.println("image not found");
            }
        }

        /**
         * method implementing TableCellRenderer
         */
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                       boolean hasFocus, int row, int column) {
            return this;
        }
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