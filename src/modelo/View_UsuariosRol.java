/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class View_UsuariosRol {

    private String nombre;
    private String apellidos;
    private String rol;
    private String correo;
    private int telefono;
    private byte activo;

    public View_UsuariosRol(String nombre, String apellidos, String rol, String correo, int telefono, byte activo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rol = rol;
        this.correo = correo;
        this.telefono = telefono;
        this.activo = activo;
    }

    public View_UsuariosRol() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

}
