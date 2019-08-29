/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuariosDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.border.EtchedBorder;
import modelo.Usuarios;
import vista.JfrmAddUsuario;
import static controlador.ControladorAdminUsuarios.admin;

public class ControladorAddUsuario implements ActionListener {

    //Frame a utilizar
    JfrmAddUsuario addUser;

    //Dao a utlizar
    UsuariosDao dao = new UsuariosDao();

    //Usuarios a utilizar
    Usuarios users = new Usuarios();

    //Controlador principal
    ControladorAdminUsuarios controlador;

    //Para contar las veces que se deja un campo vacio
    private int contarErroneas = 0;

    //Para confirmar que no se ha dejado ningun campo vacio
    private boolean error = false;

    //Para verificar que no se ha dado click en el field de fecha
    private boolean click = false;

    public ControladorAddUsuario(JfrmAddUsuario addUser) {
        this.addUser = addUser;
        setListeners();
        addUser.jLblCorreoError.setVisible(false);
        addUser.jLblErrorEstado.setText("");
        validarCampos();
    }

    public void setListeners() {
        addUser.jBtnCancelarAdd.addActionListener(this);
        addUser.jBtnGuardarAdd.addActionListener(this);
        addUser.jRbtnInactivoAdd.addActionListener(this);
        addUser.jRbtnActivoAdd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addUser.jBtnGuardarAdd) {
            validarCamposVacios();
            agregarUsuarios();
            controlador = new ControladorAdminUsuarios(admin);
            addUser.dispose();
            admin.setEnabled(true);
            admin.toFront();
        }

        if (e.getSource() == addUser.jBtnCancelarAdd) {
            addUser.dispose();
            admin.setEnabled(true);
            admin.toFront();

        }
    }

    public void validarCamposVacios() {

        //Comprobar Campo nombre
        if (addUser.jTxtNameAdd.getText().isEmpty()) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtNameAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtNameAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Comprobar Campo apellido
        if (addUser.jTxtApellidAdd.getText().isEmpty()) {

            //Coloreamos el borde de color rojo en caso esté vacio
            addUser.jTxtApellidAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtApellidAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Comprobar Campo telefono
        if (addUser.jTxtTelAdd.getText().isEmpty()) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtTelAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtTelAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Comprobamos Campo Direccion
        if (addUser.jTxtDireccionAdd.getText().isEmpty()) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtDireccionAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtDireccionAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Comprobamos campo Correo
        if (addUser.jTxtCorreoAdd.getText().isEmpty()) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtCorreoAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;

            //Verificamos si el correo contiene arroba o punto
        } else if (!addUser.jTxtCorreoAdd.getText().contains("@")
                || !addUser.jTxtCorreoAdd.getText().contains(".")) {

            //Coloreamos el borde de color Rojo en caso no lo contenga
            addUser.jTxtCorreoAdd.setBorder(new EtchedBorder(Color.RED, null));

            //Mostramos etiqueta de correo invalido
            addUser.jLblCorreoError.setVisible(true);
            contarErroneas++;
        } else {
            addUser.jTxtCorreoAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Verificamos Fecha Nacimiento 
        if (addUser.jFtxtFechaAdd.getText().contains(" ")) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jFtxtFechaAdd.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jFtxtFechaAdd.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Verificamos campo Contrasenia
        if (addUser.jTxtContrasenia.getText().isEmpty()) {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtContrasenia.setBorder(new EtchedBorder(Color.RED, null));
            contarErroneas++;
        } else {

            //Coloreamos el borde de color verde en caso esté lleno
            addUser.jTxtContrasenia.setBorder(new EtchedBorder(Color.GREEN, null));
        }

        //Verificamos si los radio buttons estan seleccionados
        if (!addUser.jRbtnActivoAdd.isSelected() && !addUser.jRbtnInactivoAdd.isSelected()) {
            addUser.jLblErrorEstado.setText("Seleccione una opción");
            contarErroneas++;
        } else {
            addUser.jLblErrorEstado.setText("");
        }

        if (contarErroneas == 0) {
            error = false;
        } else {
            error = true;
        }
    }

    public void tomarDatos() {
        users.setNombre(String.valueOf(addUser.jTxtNameAdd.getText()));
        users.setApellido(String.valueOf(addUser.jTxtApellidAdd.getText()));
        users.setDireccion(String.valueOf(addUser.jTxtDireccionAdd.getText()));
        users.setTelefono(Integer.parseInt(addUser.jTxtTelAdd.getText()));
        users.setCorreo(String.valueOf(addUser.jTxtCorreoAdd.getText()));
        users.setFecha(Date.valueOf(addUser.jFtxtFechaAdd.getText()));
        users.setContrasenia(String.valueOf(addUser.jTxtContrasenia.getText()));
        if (addUser.jRbtnActivoAdd.isSelected()) {
            users.setActivo((byte) 1);
        } else if (addUser.jRbtnInactivoAdd.isSelected()) {
            users.setActivo((byte) 2);
        }
    }

    public void agregarUsuarios() {
        if (error == false) {
            tomarDatos();
            JOptionPane.showMessageDialog(addUser, dao.agregarUsuarios(users), "Información", JOptionPane.INFORMATION_MESSAGE);
            contarErroneas = 0;
        } else if (error == true) {
            JOptionPane.showMessageDialog(addUser, "Campos vacios y/o Correo Invalido", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void validarCampos() {
        ValidarCampos validar = new ValidarCampos();
        validar.validarSoloLetras(addUser.jTxtNameAdd);
        validar.validarSoloLetras(addUser.jTxtApellidAdd);
        validar.validarSoloNumeros(addUser.jTxtTelAdd, 8);
    }
}
