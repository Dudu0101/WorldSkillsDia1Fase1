/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.View_UsuariosRol;

public interface View_UsuariosInterface {

    public ArrayList<View_UsuariosRol> verUsuarios();

    public ArrayList<View_UsuariosRol> verUsuariosRol(String rol);
}
