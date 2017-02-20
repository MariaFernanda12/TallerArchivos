/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication79;

/**
 *
 * @author Maria Fernanda
 */
public class Profesor {
     private int id;
    private char[] nombre;
    private char[] apellido;
    private int ext;
    private boolean existente;

    public Profesor(int id, char[] nombre, char[] apellido, int ext,boolean existente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ext = ext;
        this.existente=existente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }

    public boolean isExistente() {
        return existente;
    }

    public void setExistente(boolean existente) {
        this.existente = existente;
    }
}
