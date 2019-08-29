package controlador;

import dao.RolesDao;
import dao.View_UsuariosRolDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import modelo.Roles;
import modelo.View_UsuariosRol;
import vista.JfrmAddUsuario;
import vista.JfrmAdminUsuarios;
import vista.JfrmEstado;
import vista.JfrmModRol;

public class ControladorAdminUsuarios implements ActionListener, MouseListener {

    //Formularios a utilizar
    public static JfrmAdminUsuarios admin;
    JfrmAddUsuario addUser;
    JfrmEstado modEstado;
    JfrmModRol modRol;

    //Daos a utlizar
    View_UsuariosRolDao dao = new View_UsuariosRolDao();
    RolesDao dao2 = new RolesDao();

    //Controladores a utilizar
    ControladorAddUsuario controladorAdd;
    ControladorModEstado controladorEstado;
    ControladorModRol controladorRol;

    //Datos para el table
    String[] titulos = {"No.", "Nombre", "Apellido", "Rol", "Correo", "Telefono", "Estado"};
    DefaultTableModel tabla = new DefaultTableModel(titulos, 0);

    DefaultComboBoxModel roles = new DefaultComboBoxModel();

    //Variable para comprobar el error en la fila seleccionada
    public static int rol = 0;
    
    //Variable para asignar el si esta activo o inactivo
    public static String estadoMod;

    private String estado;

    public ControladorAdminUsuarios(JfrmAdminUsuarios admin) {
        this.admin = admin;
        setListeners();
        admin.jBtnCambiarEstado.setEnabled(false);
        admin.jBtnCambiarRol.setEnabled(false);
        verRoles();
        verUsuarios();
        admin.setResizable(false);

    }

    public void setListeners() {

        //Botones
        admin.jBtnCambiarEstado.addActionListener(this);
        admin.jBtnCambiarRol.addActionListener(this);

        //Labels
        admin.jLblAddUsuario.addMouseListener(this);
        admin.jLblSalir.addMouseListener(this);

        //ComboBox
        admin.jCmbRoles.addActionListener(this);

        //Tabla
        admin.jTblUsuarios.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == admin.jCmbRoles) {
            admin.jBtnCambiarEstado.setEnabled(false);
            admin.jBtnCambiarRol.setEnabled(false);
            buscarporRol();
        }

        if (e.getSource() == admin.jBtnCambiarEstado) {            
            modEstado = new JfrmEstado();
            asignarDatosHabilitar();
            controladorEstado= new ControladorModEstado(modEstado);
            modEstado.setVisible(true);
            modEstado.setLocationRelativeTo(null);
            admin.setEnabled(false);
        }

        if (e.getSource() == admin.jBtnCambiarRol) {            
            modRol = new JfrmModRol();
            asignarDatosRol();
            controladorRol = new ControladorModRol(modRol);
            modRol.setVisible(true);
            modRol.setLocationRelativeTo(null);
            admin.setEnabled(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        admin.jBtnCambiarEstado.setEnabled(true);
        admin.jBtnCambiarRol.setEnabled(true);

        //Se abre el formulario  para agregar usuarios
        if (e.getSource() == admin.jLblAddUsuario) {
            addUser = new JfrmAddUsuario();
            controladorAdd = new ControladorAddUsuario(addUser);
            admin.setEnabled(false);
            addUser.setVisible(true);
            addUser.setLocationRelativeTo(null);
        }

        if (e.getSource() == admin.jLblSalir) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {

        //Añadimos el efecto de cambiar el borde si se pasa el mouse por encima
        if (e.getSource() == admin.jLblAddUsuario) {
            admin.jLblAddUsuario.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        }

        if (e.getSource() == admin.jLblSalir) {
            admin.jLblSalir.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Añadimos el efecto de cambiar el borde si el mouse sale del boton
        if (e.getSource() == admin.jLblAddUsuario) {
            admin.jLblAddUsuario.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        }

        if (e.getSource() == admin.jLblSalir) {
            admin.jLblSalir.setBorder(new SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        }
    }

    public void limpiarTabla() {
        int a = tabla.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            tabla.removeRow(i);
        }
    }

    //Metodo para ver a los Usuarios
    public void verUsuarios() {
        limpiarTabla();
        Object[] filas = new Object[7];
        for (View_UsuariosRol verUsuario : dao.verUsuarios()) {
            filas[0] = tabla.getRowCount() + 1;
            filas[1] = verUsuario.getNombre();
            filas[2] = verUsuario.getApellidos();
            filas[3] = verUsuario.getRol();
            filas[4] = verUsuario.getCorreo();
            filas[5] = verUsuario.getTelefono();
            if (verUsuario.getActivo() == 1) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            filas[6] = estado;
            tabla.addRow(filas);
        }

        admin.jTblUsuarios.setModel(tabla);
        ColoresTabla colores = new ColoresTabla();
        admin.jTblUsuarios.setDefaultRenderer(admin.jTblUsuarios.getColumnClass(0), colores);
        tamanios();
    }

    //Metodo para llenar el comboBox de roles
    public void verRoles() {
        roles.addElement("Rol");
        for (Roles verRole : dao2.verRoles()) {
            roles.addElement(verRole.getNombre());
        }
        admin.jCmbRoles.setModel(roles);
    }

    //Metodo para filtrar por rol
    public void buscarporRol() {
        limpiarTabla();
        Object[] filas = new Object[7];
        String rol = String.valueOf(admin.jCmbRoles.getSelectedItem());
        for (View_UsuariosRol verUsuario : dao.verUsuariosRol(rol)) {
            filas[0] = tabla.getRowCount() + 1;
            filas[1] = verUsuario.getNombre();
            filas[2] = verUsuario.getApellidos();
            filas[3] = verUsuario.getRol();
            filas[4] = verUsuario.getCorreo();
            filas[5] = verUsuario.getTelefono();
            if (verUsuario.getActivo() == 1) {
                estado = "Activo";
            } else {
                estado = "Inactivo";
            }
            filas[6] = estado;
            tabla.addRow(filas);
        }
        admin.jTblUsuarios.setModel(tabla);
        ColoresTabla colores = new ColoresTabla();
        admin.jTblUsuarios.setDefaultRenderer(admin.jTblUsuarios.getColumnClass(0), colores);
        tamanios();
    }

    //Metodo para asignar un tamaño
    public void tamanios() {
        admin.jTblUsuarios.getColumnModel().getColumn(0).setMaxWidth(30);
        admin.jTblUsuarios.getColumnModel().getColumn(1).setMaxWidth(125);
        admin.jTblUsuarios.getColumnModel().getColumn(2).setMaxWidth(125);
        admin.jTblUsuarios.getColumnModel().getColumn(3).setMaxWidth(150);
        admin.jTblUsuarios.getColumnModel().getColumn(4).setMaxWidth(300);
        admin.jTblUsuarios.getColumnModel().getColumn(5).setMaxWidth(150);
        admin.jTblUsuarios.getColumnModel().getColumn(6).setMinWidth(0);
        admin.jTblUsuarios.getColumnModel().getColumn(6).setMaxWidth(0);

    }

    public void asignarDatosHabilitar() {
        modEstado.jTxtNameMod.setText(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 1)));
        modEstado.jTxtApellidoMod.setText(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 2)));
        modEstado.jTxtCorreoMod.setText(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 4)));
        modEstado.jTxtTelMOd.setText(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 5)));
        modEstado.jTxtEstado.setText(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 6)));
        estadoMod= String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 6));
    }

    public void asignarDatosRol() {
        modRol.jTxtNameRol.setText(String.valueOf(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 1))));
        modRol.jTxtApellidRol.setText(String.valueOf(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 2))));
        modRol.jTxtCorreoRol.setText(String.valueOf(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 4))));
        modRol.jTxtTelRol.setText(String.valueOf(String.valueOf(admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 5))));

        if (admin.jTblUsuarios.getValueAt(admin.jTblUsuarios.getSelectedRow(), 3).equals("Administrador")) {
            modRol.jRbtnAdmin.setSelected(true);
            rol = 1;
        } else {
            modRol.jRbtnRecepci.setSelected(true);
            rol = 2;
        }
    }

}
