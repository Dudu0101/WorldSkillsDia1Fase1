/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dia1fase1prueba;

import controlador.ControladorAdminUsuarios;
import vista.JfrmAdminUsuarios;

/**
 *
 * @author javam2019
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*JfrmLogIn vista= new JfrmLogIn();
        LogInControlador controlador= new LogInControlador(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);*/
        JfrmAdminUsuarios vista= new JfrmAdminUsuarios();
        ControladorAdminUsuarios controlador= new ControladorAdminUsuarios(vista);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }
    
}
