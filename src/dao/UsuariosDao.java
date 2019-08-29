package dao;

import interfaces.UsuariosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuarios;

public class UsuariosDao implements UsuariosInterface {

    Conexion conex = new Conexion();
    PreparedStatement ejecutar;
    ResultSet resultado;
    Usuarios users = new Usuarios();
    private String sql = null;
    private String mensaje = null;

    @Override
    public String agregarUsuarios(Usuarios users) {
        conex.conectar();
        sql = "insert into usuarios(nombre, apellido, telefono, direccion, "
                + "correo_electronico, fecha_nacimiento, rol_id, activo, "
                + "contrasenia) values(?,?,?,?,?,?,?,2,MD5(?)";
        try {
            ejecutar = conex.getConexion().prepareStatement(sql);
            ejecutar.setString(1, users.getNombre());
            ejecutar.setString(2, users.getApellido());
            ejecutar.setInt(3, users.getTelefono());
            ejecutar.setString(4, users.getDireccion());
            ejecutar.setString(5, users.getCorreo());
            ejecutar.setDate(6, users.getFecha());
            ejecutar.setByte(7, users.getActivo());
            ejecutar.setString(8, users.getContrasenia());
            ejecutar.executeUpdate();
            mensaje = "Usuario Agregado";
        } catch (SQLException ex) {
            mensaje = "Usuario no agregado";
            System.out.println("Error en daoAgregarUsuario " + ex);
        } finally {
            conex.desconectar();
        }
        return mensaje;
    }

    @Override
    public String modificarEstado(Usuarios users) {
        conex.conectar();
        sql = "update usuarios set activo=? where correo_electronico=?";
        try {
            ejecutar = conex.getConexion().prepareStatement(sql);
            ejecutar.setByte(1, users.getActivo());
            ejecutar.setString(2, users.getCorreo());
            ejecutar.executeUpdate();
            mensaje = "Estado Modificado";
        } catch (SQLException ex) {
            mensaje = "Usuario no agregado";
            System.out.println("Error en daoAgregarUsuario " + ex);
        } finally {
            conex.desconectar();
        }
        return mensaje;
    }

    @Override
    public String modificarRol(Usuarios users) {
        conex.conectar();
        sql = "update usuarios set rol_id=? where correo_electronico=?";
        try {
            ejecutar = conex.getConexion().prepareStatement(sql);
            ejecutar.setByte(1, users.getRol());
            ejecutar.setString(2, users.getCorreo());
            ejecutar.executeUpdate();
            mensaje = "Estado Modificado";
        } catch (SQLException ex) {
            mensaje = "Usuario no agregado";
            System.out.println("Error en daoAgregarUsuario " + ex);
        } finally {
            conex.desconectar();
        }
        return mensaje;
    }

    @Override
    public Usuarios verificar(String correo, String contrasenia) {
        conex.conectar();
        sql = "select * from usuarios where correo_electronico=? && contrasenia=MD5(?)";
        try {
            ejecutar = conex.getConexion().prepareStatement(sql);
            ejecutar.setString(1, correo);
            ejecutar.setString(2, contrasenia);
            resultado = ejecutar.executeQuery();
            resultado.next();
            users= new Usuarios();
            users.setCorreo(resultado.getString("correo_electronico"));
            users.setContrasenia(resultado.getString("contrasenia"));
            users.setNombre(resultado.getString("nombre"));
            users.setApellido(resultado.getString("apellido"));
            users.setRol(resultado.getByte("rol_id"));
            users.setActivo(resultado.getByte("activo"));
            resultado.close();
        } catch (SQLException ex) {
            System.out.println("Error en daoverificar " + ex);
        }
        return users;
    }
}
