package dao;

import interfaces.View_UsuariosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.View_UsuariosRol;


public class View_UsuariosRolDao implements View_UsuariosInterface {
    
    Conexion cone = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    ArrayList<View_UsuariosRol> lista;
    View_UsuariosRol usuariosRol = new View_UsuariosRol();
    
    private String sql = null;
    
    @Override
    public ArrayList<View_UsuariosRol> verUsuarios() {
        cone.conectar();
        sql = "select * from usuarios_rol";
        lista = new ArrayList();
        try {
            ejecutar = cone.getConexion().prepareStatement(sql);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                usuariosRol = new View_UsuariosRol();
                usuariosRol.setNombre(resultado.getString("Nombre"));
                usuariosRol.setApellidos(resultado.getString("Apellido"));
                usuariosRol.setRol(resultado.getString("Rol"));
                usuariosRol.setCorreo(resultado.getString("Correo"));
                usuariosRol.setTelefono(resultado.getInt("Telefono"));
                usuariosRol.setActivo(resultado.getByte("activo"));
                lista.add(usuariosRol);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerUsuarios " + ex);
        } finally {
            cone.desconectar();
        }
        return lista;
    }
    
    @Override
    public ArrayList<View_UsuariosRol> verUsuariosRol(String rol) {
        cone.conectar();
        sql = "select * from usuarios_rol where Rol=?";
        lista = new ArrayList();
        try {
            ejecutar = cone.getConexion().prepareStatement(sql);
            ejecutar.setString(1, rol);
            resultado = ejecutar.executeQuery();
            while (resultado.next()) {
                usuariosRol = new View_UsuariosRol();
                usuariosRol.setNombre(resultado.getString("Nombre"));
                usuariosRol.setApellidos(resultado.getString("Apellido"));
                usuariosRol.setRol(resultado.getString("Rol"));
                usuariosRol.setCorreo(resultado.getString("Correo"));
                usuariosRol.setTelefono(resultado.getInt("Telefono"));
                usuariosRol.setActivo(resultado.getByte("activo"));
                lista.add(usuariosRol);
            }
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoVerUsuarios " + ex);
        } finally {
            cone.desconectar();
        }
        return lista;
    }
    
}
