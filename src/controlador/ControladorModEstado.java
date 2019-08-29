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

    public void setTextFieldEditable() {
        estado.jTxtNameMod.setEditable(false);
        estado.jTxtApellidoMod.setEditable(false);
        estado.jTxtCorreoMod.setEditable(false);
        estado.jTxtTelMOd.setEditable(false);
        estado.jTxtEstado.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        estado.jBtnCambiarEstado.setEnabled(estado.jRbtnHabilitar.isSelected() || estado.jRbtnDeshab.isSelected());

        if (e.getSource() == estado.jRbtnHabilitar) {
            estado.jTxtEstado.setText("Activo");
        }

        if (e.getSource() == estado.jRbtnDeshab) {
            estado.jTxtEstado.setText("Inactivo");
        }
        
        if (e.getSource() == estado.jBtnCambiarEstado) {
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
            users.setActivo((byte) 1);

        } else if (estado.jRbtnDeshab.isSelected()) {
            users.setActivo((byte) 2);

        }
        users.setCorreo(String.valueOf(estado.jTxtCorreoMod.getText()));

        JOptionPane.showMessageDialog(estado, dao.modificarEstado(users), "Información", JOptionPane.INFORMATION_MESSAGE);
    }

}
