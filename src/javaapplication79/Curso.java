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
public class Curso {
    private int id;
    private char []nombre;
    private int duracion;
    private int idprofesor;

    public Curso(int id, char[] nombre, int duracion, int idprofesor) {
        this.id = id;
        this.nombre = nombre;
        this.duracion = duracion;
        this.idprofesor = idprofesor;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

}
