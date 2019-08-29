/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Usuarios;

/**
 *
 * @author javam2019
 */
public interface UsuariosInterface {

    public Usuarios verificar(String correo, String contrasenia);
    
    public String agregarUsuarios(Usuarios users);

    public String modificarEstado(Usuarios users);

    public String modificarRol(Usuarios users);
}
