/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.ControladorAdminUsuarios.admin;
import dao.UsuariosDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.Usuarios;
import vista.JfrmAdminUsuarios;
import vista.JfrmLogIn;

/**
 *
 * @author javam2019
 */
public class LogInControlador implements ActionListener, KeyListener {

    //Frame
    JfrmLogIn vista;

    //Dao a utilizar
    UsuariosDao dao = new UsuariosDao();

    //Modelo a utilizar
    Usuarios users = new Usuarios();

    //Controlador a utilizar
    ControladorAdminUsuarios controlador;

    private String ruta = System.getProperty("user.dir");
    private String nl = System.getProperty("line.separator");

    //Variables para realizar la consulta
    private String correo;
    private String password;

    private String mensaje = null;

    //Variable para contar errores y el tiempo para activar el boton
    private int contar = 10;
    private int contarClick = 0;

    public LogInControlador(JfrmLogIn vista) {
        this.vista = vista;

        vista.jTxtUser.requestFocus();
        //Imagen principal
        ImageIcon icon = new ImageIcon(ruta + "\\src\\vista\\logo.png");
        ImageIcon iconoRed = new ImageIcon(icon.getImage().getScaledInstance(150, -1, java.awt.Image.SCALE_DEFAULT));
        vista.jLblImagen.setIcon(iconoRed);

        //Listener
        vista.jBtnIngresar.addActionListener(this);
        vista.jTxtUser.addKeyListener(this);
        vista.jPswContra.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.jBtnIngresar) {
            verificarSesion();
            contarSesion();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getSource() == vista.jTxtUser) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.jPswContra.requestFocus();
            }
        }

        if (e.getSource() == vista.jPswContra) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.jBtnIngresar.doClick();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //
    }

    public void verificarSesion() {

        correo = vista.jTxtUser.getText();
        password = vista.jPswContra.getText();
        users = dao.verificar(correo, password);

        /**
         * Verifica datos correctos
         */
        if (users.getCorreo() != null
                && users.getRol() == 1
                && users.getActivo() == 1) {
            admin = new JfrmAdminUsuarios();
            controlador = new ControladorAdminUsuarios(admin);
            admin.setVisible(true);
            admin.setLocationRelativeTo(null);
            admin.jLblNombreUsuario.setText(users.getNombre() + " " + users.getApellido());
            vista.dispose();

        } else if (users.getCorreo() != null && users.getActivo() == 2) {
            mensaje = "No cuenta con acceso al sistema" + nl
                    + "dado a que se encuentra en estado inactivo";
            JOptionPane.showMessageDialog(vista, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else if (users.getCorreo() != null
                && users.getRol() == 2
                && users.getActivo() == 1) {
            mensaje = "Formulario en contrucción";
            JOptionPane.showMessageDialog(vista, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

        } else {
            contarClick++;
            mensaje = "Datos incorrectos";
            JOptionPane.showMessageDialog(vista, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void contarSesion() {
        if (contarClick == 3) {
            vista.jBtnIngresar.setEnabled(false);
            cuenta.start();
        }
    }

    //Timmer para contar clicks y deshabilitar el boton
    Timer cuenta = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            //El contandor empieza a disminuir
            contar--;
            vista.jLblConteo.setText("Reintentar en " + contar);

            //Evaluamos si los segundos ya llegaron a cero
            if (contar == 0) {
                cuenta.stop();
                vista.jLblConteo.setText("");
                vista.jBtnIngresar.setEnabled(true);
                contarClick = 0;
                contar = 10;
            }
        }

    });

}
