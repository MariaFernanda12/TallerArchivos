/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication79;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.applet.Main;
/**
 *
 * @author Maria Fernanda
 */
public class JavaApplication79 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         try {
           
            ProfesorDAO profesordao = new ProfesorDAO();
            
            char[] nombre = {'f','a','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            char[] apellido={'g','i','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            int ext = 15;
            boolean existente=true;
            Arbol pr = new Arbol();
            for(int i =0 ;i<10;i++){
               Profesor profesor=new Profesor(i, nombre, apellido ,ext,existente);
              
            }
            
            //profesordao.destructor();
            profesordao.listarTodo();
            //profesordao.borrar(1);
            
            //   ProfesorDAO.cargardatos();
            
            
            ProfesorDAO.guardarD();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            EstudianteDAO estudiantedao = new EstudianteDAO();
            int codigo = 1;
            char[] nombre = {'N','a','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            char[] apellido={'l','i','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
       
            Arbol pr = new Arbol();
            for(int i =0 ;i<10;i++){
               Estudiante estudiante=new Estudiante(i, nombre, apellido );
              
            }
            
            //estudiantedao.destructor();
            estudiantedao.listarTodo();
            //estudiantedao.borrar(3);
            
//            EstudianteDAO.cargardatos();
            
            
            EstudianteDAO.guardarD();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try {
            CursoDAO profesordao = new CursoDAO();
            int codigo = 1;
            char[] nombre = {'t','m','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000','\u0000'};
            
            int duracion = 80;
            int IdProfesor=4;
            Arbol pr = new Arbol();
            for(int i =0 ;i<10;i++){
               Curso curso=new Curso(i, nombre, duracion,IdProfesor);
              
            }
            
            //cursodao.destructor();
            profesordao.listarTodo();
            //cursodao.borrar(5);
            
//            CursoDAO.cargardatos();
            
            
           CursoDAO.guardarD();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     try {
           
            InscripcionDAO inscripciondao = new InscripcionDAO();
            
            char[] fechai = {'A','b','r','i','l','\u0000','\u0000','\u0000','\u0000','\u0000'};
            char[] fechaf={'J','u','n','i','o','\u0000','\u0000','\u0000','\u0000','\u0000'};
             int idEstudiante=9;
             int idCurso=5;
             double nota=3.5;
            for(int i =0 ;i<10;i++){
               Inscripcion inscripcion=new Inscripcion(i, idEstudiante, idCurso ,fechai,fechaf,nota);
              
            }
            
            //inscripciondao.destructor();
            inscripciondao.listarTodo();
            //inscripciondao.borrar(1);
            
            //   inscripciondao.cargardatos();
            
            
            InscripcionDAO.guardarD();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }         
       
    }
    
}
