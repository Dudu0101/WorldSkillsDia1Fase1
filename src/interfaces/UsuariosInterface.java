/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import modelo.Usuarios;

public interface UsuariosInterface {

    //Login
    public Usuarios verificar(String correo, String contrasenia);
    
    //Agregar
    public String agregarUsuarios(Usuarios users);

    //Modificar estado
    public String modificarEstado(Usuarios users);

    //Modificar Ro
    public String modificarRol(Usuarios users);
}
