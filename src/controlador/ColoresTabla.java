package controlador;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ColoresTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);

        this.setOpaque(true);

        //Evaluamos si el valor de la columna equivale a activo o a inactivo
        if (table.getValueAt(row, 6).toString().equals("Inactivo")) {
            
            //Pintamos de color Rojo claro 
            this.setBackground(new java.awt.Color(192, 57, 43));
        } else if (table.getValueAt(row, 3).toString().equals("Administrador")) {
            
            //Pintamos de color rojo claro
            this.setBackground(new java.awt.Color(133, 193, 233));
        } else {
            this.setBackground(Color.white);
        }

        return this;
    }

}
