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
        // Temporal, ya que no está implementado SQL
        addData();

        // Configuración de la tabla
        configTable();

    }

    private void addData() {

        DefaultTableModel model = Columns();

        ArrayList<Producto> products = new ArrayList<>();
        products.add(new Producto(1, "El producto es muy ítil por que te lava la cara ca asd", "NombreUNO", "Laboratorio 1", 1.0, 1, "src/main/resources/img/productos/apositos.png", "SI"));
        products.add(new Producto(2, "El producto es muy ítil por que te lava la cara ca asd", "NombreDOS", "Laboratorio 2", 2.0, 2, "src/main/resources/img/productos/aspirina.png", "NO"));
        products.add(new Producto(3, "El producto es muy ítil por que te lava la cara ca asd", "NombreTRES", "Laboratorio 3", 3.0, 3, "src/main/resources/img/productos/bendaje.png", "SI"));
        products.add(new Producto(4, "El producto es muy ítil por que te lava la cara ca asd", "NombreCUATRO", "Laboratorio 4", 4.0, 1, "src/main/resources/img/productos/cafeina.png", "NO"));

        for (Producto product : products) {
            model.addRow(new Object[]{
                    product.getUtilidad(),
                    product.getNombre(),
                    product.getLaboratorio(),
                    product.getPrecio() + "€",
                    product.getStock(),
                    product.getFoto()});
        }

    }

    private DefaultTableModel Columns() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Utilidad");
        model.addColumn("Nombre");
        model.addColumn("Laboratorio");
        model.addColumn("Precio");
        model.addColumn("Stock");
        model.addColumn("Foto");
        jtableProduct.setModel(model);
        return model;
    }

    private void configTable() {

        jtableProduct.setRowHeight(50);
        jtableProduct.getTableHeader().setReorderingAllowed(false);
        jtableProduct.getColumnModel().getColumn(5).setCellRenderer(new ImageRender());
        jtableProduct.setDefaultEditor(Object.class, null);
        ocultarColumnas();
        ocultarProductInfo(false);

        jtableProduct.getSelectionModel().addListSelectionListener(e -> {
            ocultarProductInfo(true);
            int row = jtableProduct.getSelectedRow();
            if (row >= 0) {
                lblImage.setIcon(new ImageIcon(jtableProduct.getValueAt(row, 5).toString()));
                lblNombre.setText("Nombre del producto: " + jtableProduct.getValueAt(row, 1).toString());
                lblDesc.setText("Descripción: " + jtableProduct.getValueAt(row, 0).toString());
                lblPrecio.setText("Precio: " + jtableProduct.getValueAt(row, 3).toString());

                if (Integer.parseInt(jtableProduct.getValueAt(row, 4).toString()) >= 3) {
                    lblStock.setText("Stock: " + jtableProduct.getValueAt(row, 4).toString());
                } else if (Integer.parseInt(jtableProduct.getValueAt(row, 4).toString()) <= 2 && Integer.parseInt(jtableProduct.getValueAt(row, 4).toString()) > 0) {
                    lblStock.setText("Stock: " + jtableProduct.getValueAt(row, 4).toString() + " (Más unidades en el almacén)");
                } else if (Integer.parseInt(jtableProduct.getValueAt(row, 4).toString()) == 0) {
                    lblStock.setText("Stock: No disponible");
                }

                lblImage.setPreferredSize(new Dimension(100, 100)); // Tamaño de la imagen

            }
        });

        confiAnchoColumnas();


    }

    private void ocultarProductInfo(boolean b) {
        lblImage.setVisible(b);
        lblNombre.setVisible(b);
        lblPrecio.setVisible(b);
        lblStock.setVisible(b);
        lblDesc.setVisible(b);
        btnComprar.setVisible(b);
    }

    private void confiAnchoColumnas() {
        // Configuracion del ancho de las columnas
        jtableProduct.getColumnModel().getColumn(0).setPreferredWidth(100); // Utilidad
        jtableProduct.getColumnModel().getColumn(1).setPreferredWidth(200); // Nombre
        jtableProduct.getColumnModel().getColumn(2).setPreferredWidth(200); // Laboratorio
        jtableProduct.getColumnModel().getColumn(3).setPreferredWidth(50); // Precio
        jtableProduct.getColumnModel().getColumn(4).setPreferredWidth(50); // Stock
        jtableProduct.getColumnModel().getColumn(5).setPreferredWidth(100); // Foto
    }

    private void ocultarColumnas() {
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
