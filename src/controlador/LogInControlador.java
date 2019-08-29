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
    
    //variable para contar los click realizados en el frame 
    private int contarClick = 0;

    public LogInControlador(JfrmLogIn vista) {
        this.vista = vista;

        //Asignamos el foco al primer textfield
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
            
            //Metodo para verificar los datos y sus diferentes casos
            verificarSesion();
            
            //En dado caso se cometan faltas se iniciará el temporizador
            contarSesion();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Si el foco está en la caja de texto de usuario
        if (e.getSource() == vista.jTxtUser) {
            
            //Pasamos el foco a la caja de texto de contrasenia mediante la tecla enter 
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                vista.jPswContra.requestFocus();
            }
        }

        //Si el foco esta en la caja de texto de usuario
        if (e.getSource() == vista.jPswContra) {
            
            //Pasamos el foco a la caja de texto de contrasenia mediante la tecla enter
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

        //Asignamos valores de la caja de texto a los parametros para nuestra consulta
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

            //Verifica si el usuario tiene datos correctos pero estado inactivo
        } else if (users.getCorreo() != null && users.getActivo() == 2) {
            mensaje = "No cuenta con acceso al sistema" + nl
                    + "dado a que se encuentra en estado inactivo";
            JOptionPane.showMessageDialog(vista, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

            //Verificamos los datos son correcto y esta en estado activo pero es Recepcionista
        } else if (users.getCorreo() != null
                && users.getRol() == 2
                && users.getActivo() == 1) {
            mensaje = "Formulario en contrucción";
            JOptionPane.showMessageDialog(vista, mensaje, "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);

            //Si los datos son incorrectos 
        } else {
            
            //aumentamos las veces que se presiona el boton
            contarClick++;
            mensaje = "Datos incorrectos";
            JOptionPane.showMessageDialog(vista, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void contarSesion() {
        
        //Si se ingresan datos incorrectos más de tres veces
        if (contarClick == 3) {
            
            //deshabilitamos el boton
            vista.jBtnIngresar.setEnabled(false);
            
            //Empezamos el timer
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
                
                //Detenemos el timer
                cuenta.stop();
                
                //Quitamos el texto del label
                vista.jLblConteo.setText("");
                
                //habilitamos el boton
                vista.jBtnIngresar.setEnabled(true);
                
                //Reiniciamos variables
                contarClick = 0;
                contar = 10;
            }
        }

    });

}
