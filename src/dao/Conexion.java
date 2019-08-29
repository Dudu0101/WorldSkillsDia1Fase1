package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    public static final String USER="duinlisi";
    public static final String PASSWORD="1234";
    public static final String URL="jdbc:mysql://localhost:3306/java19_ver";
    
    private Connection conexion;

    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion= DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en Driver " + ex);
        } catch (SQLException ex) {
            System.out.println("Error en daoConectar " + ex);
        }
    }
    
    public void desconectar(){
        try {
            if(conexion.isClosed()!=true && conexion!=null){
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error en dao Desconectar " + ex);
        }
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

}
