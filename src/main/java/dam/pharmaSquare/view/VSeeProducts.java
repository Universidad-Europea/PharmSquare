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
            model.addRow(new Object[]{product.getUtilidad(),
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
