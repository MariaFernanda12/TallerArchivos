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
public class Inscripcion {
      private int idInscripcion;
   private int idEstudiante;
   private int idCurso;
   private char []Fechai;
   private char []Fachaf;
   private double nota;

    public Inscripcion(int idInscripcion, int idEstudiante, int idCurso, char[] Fechai, char[] Fachaf, double nota) {
        this.idInscripcion = idInscripcion;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.Fechai = Fechai;
        this.Fachaf = Fachaf;
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public char[] getFechai() {
        return Fechai;
    }

    public void setFechai(char[] Fechai) {
        this.Fechai = Fechai;
    }

    public char[] getFachaf() {
        return Fachaf;
    }

    public void setFachaf(char[] Fachaf) {
        this.Fachaf = Fachaf;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
}
