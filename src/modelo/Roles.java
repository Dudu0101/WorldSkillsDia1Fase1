/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Roles {

    private byte rol_id;
    private String nombre;

    public Roles(byte rol_id, String nombre) {
        this.rol_id = rol_id;
        this.nombre = nombre;
    }

    public Roles() {
    }

    public byte getRol_id() {
        return rol_id;
    }

    public void setRol_id(byte rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
