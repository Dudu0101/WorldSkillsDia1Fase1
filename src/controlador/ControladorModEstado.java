package controlador;

import dao.UsuariosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import vista.JfrmEstado;
import static controlador.ControladorAdminUsuarios.admin;
import static controlador.ControladorAdminUsuarios.estadoMod;

public class ControladorModEstado implements ActionListener {

    JfrmEstado estado;

    //Dao a utilizar
    UsuariosDao dao = new UsuariosDao();

    //Controlador principal
    ControladorAdminUsuarios controlador;

    //Modelo a utilizar
    Usuarios users = new Usuarios();

    public ControladorModEstado(JfrmEstado estado) {
        this.estado = estado;
        setListeners();
        setTextFieldEditable();
        estado.jBtnCambiarEstado.setEnabled(false);
    }

    public void setListeners() {
        estado.jBtnCambiarEstado.addActionListener(this);
        estado.jBtnCancelar.addActionListener(this);
        estado.jRbtnDeshab.addActionListener(this);
        estado.jRbtnHabilitar.addActionListener(this);
    }

    //Añadir no editable a los textFields
    public void setTextFieldEditable() {
        estado.jTxtNameMod.setEditable(false);
        estado.jTxtApellidoMod.setEditable(false);
        estado.jTxtCorreoMod.setEditable(false);
        estado.jTxtTelMOd.setEditable(false);
        estado.jTxtEstado.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Habilitar el boton Guardar Cambios a seleccionar uno de los radiobuttons
        estado.jBtnCambiarEstado.setEnabled(estado.jRbtnHabilitar.isSelected() || estado.jRbtnDeshab.isSelected());

        if (e.getSource() == estado.jRbtnHabilitar) {
            
            //Asignar el estado al textField dependiendo del radio button seleccionado
            estado.jTxtEstado.setText("Activo");
        }

        if (e.getSource() == estado.jRbtnDeshab) {
            
            //Asignar el estado al textField dependiendo del radio button seleccionado
            estado.jTxtEstado.setText("Inactivo");
        }
        
        if (e.getSource() == estado.jBtnCambiarEstado) {
            
            //Metodo para modificar el estado
            modificarEstado();
            estado.dispose();
            admin.setEnabled(true);
            admin.toFront();
            controlador = new ControladorAdminUsuarios(admin);
        }

        if (e.getSource() == estado.jBtnCancelar) {
            estado.dispose();
            admin.setEnabled(true);
            admin.toFront();
        }
    }

    public void modificarEstado() {
        if (estado.jRbtnHabilitar.isSelected()) {
            
            //Si el btn de habilitar esta seleccionado damos el ID de 1
            users.setActivo((byte) 1);

        } else if (estado.jRbtnDeshab.isSelected()) {
            
            //Si el btn de deshabilitar esta seleccionado damos el ID de 2
            users.setActivo((byte) 2);

        }
        
        //Damos el parametro de correo para modificar
        users.setCorreo(String.valueOf(estado.jTxtCorreoMod.getText()));

        JOptionPane.showMessageDialog(estado, dao.modificarEstado(users), "Información", JOptionPane.INFORMATION_MESSAGE);
    }

}
