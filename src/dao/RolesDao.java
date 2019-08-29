/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.RolesInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Roles;

/**
 *
 * @author javam2019
 */
public class RolesDao implements RolesInterface {

    PreparedStatement ejecutar;
    ResultSet resultado;
    Conexion cone = new Conexion();
    private String sql = null;
    ArrayList<Roles> lista;
    Roles rol= new Roles();

    @Override
    public ArrayList<Roles> verRoles() {
        cone.conectar();
        lista = new ArrayList();
        sql = "select nombre from roles";
        try {
            ejecutar = cone.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while(resultado.next()){
                rol= new Roles();
                rol.setNombre(resultado.getString("nombre"));
                lista.add(rol);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerRoles " + ex);
        }
        return lista;
    }

}
