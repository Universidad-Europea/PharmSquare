package dam.pharmaSquare.view;

import dam.pharmaSquare.model.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class VSeeProducts extends JPanel {
    private JPanel panel1;
    private JTable jtableProduct;
    private JLabel lblImage;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JLabel lblStock;
    private JLabel lblDesc;
    private JButton btnComprar;


    public VSeeProducts() {
        add(panel1);
        configTable();

    }


    private void configTable() {

        ArrayList<Producto> products = new ArrayList<>();

        products.add(new Producto(1, "El producto es muy ítil por que te lava la cara ca asd", "NombreUNO", "Laboratorio 1", 1.0, 1, "src/main/resources/img/buttons/ok.png", "SI"));
        products.add(new Producto(2, "El producto es muy ítil por que te lava la cara ca asd", "NombreDOS", "Laboratorio 2", 2.0, 2, "src/main/resources/img/buttons/delete.png", "NO"));

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Utilidad");
        model.addColumn("Nombre");
        model.addColumn("Laboratorio");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Foto");

        for (Producto product : products) {
            model.addRow(new Object[]{
                    product.getUtilidad(),
                    product.getNombre(),
                    product.getLaboratorio(),
                    product.getPrecio() + "€",
                    product.getStock(),
                    product.getFoto()});
        }

        jtableProduct.setModel(model);
        jtableProduct.setRowHeight(50);
        jtableProduct.getTableHeader().setReorderingAllowed(false);
        jtableProduct.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
        jtableProduct.setDefaultEditor(Object.class, null);
        // ---
        jtableProduct.getColumnModel().getColumn(4).setMinWidth(0);
        jtableProduct.getColumnModel().getColumn(4).setMaxWidth(0);
        jtableProduct.getColumnModel().getColumn(4).setPreferredWidth(0);
        // ---
        jtableProduct.getColumnModel().getColumn(2).setMinWidth(0);
        jtableProduct.getColumnModel().getColumn(2).setMaxWidth(0);
        jtableProduct.getColumnModel().getColumn(2).setPreferredWidth(0);
        // ---
        jtableProduct.getColumnModel().getColumn(0).setMinWidth(0);
        jtableProduct.getColumnModel().getColumn(0).setMaxWidth(0);
        jtableProduct.getColumnModel().getColumn(0).setPreferredWidth(0);



        // Get select row and display in label
        jtableProduct.getSelectionModel().addListSelectionListener(e -> {
            int row = jtableProduct.getSelectedRow();
            if (row >= 0) {
                lblImage.setIcon(new ImageIcon(jtableProduct.getValueAt(row, 5).toString()));
                lblNombre.setText("Nombre del producto: " + jtableProduct.getValueAt(row, 1).toString());
                lblDesc.setText("Descripción: " + jtableProduct.getValueAt(row, 0).toString());
                lblPrecio.setText("Precio: " + jtableProduct.getValueAt(row, 3).toString());

                if (Integer.parseInt(jtableProduct.getValueAt(row, 4).toString()) > 0) {
                    lblStock.setText("Stock: " + jtableProduct.getValueAt(row, 4).toString());
                } else {
                    lblStock.setText("Stock: No disponible");
                }

                lblImage.setPreferredSize(new Dimension(100, 100));

            }
        });

        jtableProduct.getColumnModel().getColumn(0).setPreferredWidth(100);
        jtableProduct.getColumnModel().getColumn(1).setPreferredWidth(200);
        jtableProduct.getColumnModel().getColumn(2).setPreferredWidth(200);
        jtableProduct.getColumnModel().getColumn(3).setPreferredWidth(50);
        jtableProduct.getColumnModel().getColumn(4).setPreferredWidth(50); // Stock
        jtableProduct.getColumnModel().getColumn(5).setPreferredWidth(100);


    }

    private int getSelectedRow() {
        return jtableProduct.getSelectedRow();
    }

    private class ImageRender extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                       int row, int column) {

            String dirPhoto = value.toString();

            ImageIcon icon = new ImageIcon(
                    new ImageIcon(dirPhoto).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));


            return new JLabel(icon);
        }
    }
}
