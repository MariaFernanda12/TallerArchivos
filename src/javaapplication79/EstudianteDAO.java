/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication79;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
/**
 *
 * @author Maria Fernanda
 */
public class EstudianteDAO {
      private static  final String path="C:\\Archivos_JAVA\\contacto2.obj";
    public static   Arbol b = new Arbol(); ;
     private RandomAccessFile estudianteDB;
       private static int numeroRegistros;
     int  numeroregistros;    
     int tamañoregistroString=10;
     
     long  posicionMemoriaArbol=0;  
    
    public EstudianteDAO() throws FileNotFoundException{
      this.estudianteDB = new RandomAccessFile("profesor.txt", "rw");
    }
    
    public boolean insertar(Estudiante estudiante) throws IOException{
        numeroRegistros++;//variable que cuenta el numero de registro
        
        long posicionMemoriaRegistros = this.estudianteDB.length();
        b.insertar(estudiante.getId(),posicionMemoriaRegistros);
        
        this.estudianteDB.seek(posicionMemoriaRegistros);
        this.estudianteDB.writeInt(estudiante.getId()); //id
    
        for(int i = 0;i < 10; i++){
          
            
          char letra = estudiante.getNombre()[i];
          this.estudianteDB.writeChar(letra);
        }
        if(estudiante.getNombre().length<tamañoregistroString){
        long numdebyte=estudiante.getNombre().length-tamañoregistroString;
        this.estudianteDB.seek(numdebyte);
            
        }
      
        
        for(int i = 0;i < 10; i++){
          char letra = estudiante.getApellido()[i];
          this.estudianteDB.writeChar(letra);
        }
        
        if(estudiante.getApellido().length<tamañoregistroString){
           
      long numdebyte1=estudiante.getApellido().length-tamañoregistroString;
        this.estudianteDB.seek(numdebyte1);
         
        }
       
        this.estudianteDB.writeInt(estudiante.getId());
        
       
        return true;
    }
   
    
   
    
    public boolean borrar( int index) throws IOException{
      Arbol ar=  b.buscar(b, index);
      ar.activo=false;
      this.estudianteDB.seek(ar.pos);
      
      return false;
    }
   
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.estudianteDB.length();i= i + 48){
           this.estudianteDB.seek(i);
           System.out.println(this.estudianteDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.estudianteDB.readChar());
           }
           System.out.println("");
           
       
       }
       
     
       
       
       return null;
    }
    
    public void destructor() throws IOException{
      this.estudianteDB.close();
    }
    
    
    public void buscar(int index) throws IOException{
        Arbol ar = b.buscar(b, index);
        this.estudianteDB.seek(ar.pos);
        this.estudianteDB.readLine();
         System.out.println(this.estudianteDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.estudianteDB.readChar());
           }
      
        
        
    }
  
    public static  void cargardatos() throws IOException,ClassNotFoundException{
        try{
            b = new Arbol();
            ObjectInputStream fileIn = new ObjectInputStream(new FileInputStream(path) );
            b=(Arbol) fileIn.readObject();
            fileIn.close();
        }catch(FileNotFoundException e){
            b=new Arbol();  
       }
   }
    
    public static void guardarD() throws IOException{
        ObjectOutputStream fileO= new ObjectOutputStream(new FileOutputStream(path) );
        fileO.writeObject(b);
    }
    
}
