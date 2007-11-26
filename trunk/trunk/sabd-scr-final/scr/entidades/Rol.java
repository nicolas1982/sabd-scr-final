/*
 * Rol.java
 *
 * Created on 19 de noviembre de 2007, 2:02
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package scr.entidades;

/**
 *
 * @author Administrador
 */
public enum Rol {
    PRODUCTOR (0, "Productor"),
    ADMINISTRADOR   (1, "Administrador");
    
    private final int idRol;
    private final String descRol;
    
    public int getIdRol() {
        return this.idRol;
    }
    
    public String getDescRol() {
        return this.descRol;
    }
    
    Rol(int idRol, String descripcionRol) {
        this.idRol = idRol;
        this.descRol = descripcionRol;
    }
}
