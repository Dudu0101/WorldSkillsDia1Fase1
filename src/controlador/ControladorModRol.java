package controlador;

import static controlador.ControladorAdminUsuarios.admin;
import static controlador.ControladorAdminUsuarios.rol;
import dao.UsuariosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Usuarios;
import vista.JfrmModRol;

public class ControladorModRol implements ActionListener {

    //Frames a utilizar
    JfrmModRol mod;

    //Modelos a utilizar
    Usuarios users = new Usuarios();
    ValidarCampos valid;

    //Dao a utilizar
    UsuariosDao dao = new UsuariosDao();

    //Controlador frame principal
    ControladorAdminUsuarios controlador;

    public ControladorModRol(JfrmModRol mod) {
        this.mod = mod;
        habilitarBoton();
        setListeners();
        deshabilitarTextFields();
        mod.jBtnCambiarRol.setEnabled(false);
        System.out.println(rol);
    }

    public void setListeners() {
        mod.jBtnCambiarRol.addActionListener(this);
        mod.jBtnCancelar.addActionListener(this);
    }

    public void deshabilitarTextFields() {
        mod.jTxtNameRol.setEditable(false);
        mod.jTxtApellidRol.setEditable(false);
        mod.jTxtCorreoRol.setEditable(false);
        mod.jTxtTelRol.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Metodo para habilitar al seleccionar una opcion que no sea la ya establecida
        habilitarBoton();
        if (e.getSource() == mod.jRbtnAdmin) {
            mod.jBtnCambiarRol.setEnabled(true);
        }

        if (e.getSource() == mod.jRbtnRecepci) {
            mod.jBtnCambiarRol.setEnabled(true);
        }

        if (e.getSource() == mod.jBtnCambiarRol) {
            modificarRol();
            controlador = new ControladorAdminUsuarios(admin);
            mod.dispose();
            admin.setEnabled(true);
            admin.toFront();
        }

        if (e.getSource() == mod.jBtnCancelar) {
            mod.dispose();
            admin.setEnabled(true);
            admin.toFront();

        }
        
        //Metodo para habilitar al seleccionar una opcion que no sea la ya establecida
        habilitarBoton();

    }

    //Metodo para habilitar al seleccionar una opcion que no sea la ya establecida
    public void habilitarBoton() {
        
        //Si la variable estatica del frame principal es igual a 1 osea es Administrador
        if (rol == 1) {
            
            //Añadimos action listener al radio button de recepcionista
            mod.jRbtnRecepci.addActionListener(this);
        } else if (rol == 2) {
            
            //De lo contrario se lo agregamos al radio button de administrador
            mod.jRbtnAdmin.addActionListener(this);
        }
    }

    //metodo para modificar rol
    public void modificarRol() {
        users.setCorreo(String.valueOf(mod.jTxtCorreoRol.getText()));
        if (mod.jRbtnRecepci.isSelected()) {
            users.setRol((byte) 2);
        } else if (mod.jRbtnAdmin.isSelected()) {
            users.setRol((byte) 1);
        }
        JOptionPane.showMessageDialog(mod, dao.modificarRol(users), "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
