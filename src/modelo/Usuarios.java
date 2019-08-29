package modelo;

import java.sql.Date;

public class Usuarios {

    private int usuarioId;
    private String nombre;
    private String apellido;
    private int telefono;
    private String direccion;
    private String correo;
    private Date fecha;
    private byte rol;
    private byte activo;
    private String contrasenia;

    public Usuarios(int usuarioId, String nombre, String apellido, int telefono, String direccion, String correo, Date fecha, byte rol, byte activo, String contrasenia) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.fecha = fecha;
        this.rol = rol;
        this.activo = activo;
        this.contrasenia = contrasenia;
    }

    public Usuarios() {
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public byte getRol() {
        return rol;
    }

    public void setRol(byte rol) {
        this.rol = rol;
    }

    public byte getActivo() {
        return activo;
    }

    public void setActivo(byte activo) {
        this.activo = activo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}
