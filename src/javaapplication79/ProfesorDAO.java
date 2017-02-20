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
public class ProfesorDAO {
      private static  final String path="C:\\Archivos_JAVA\\contacto1.obj";
    public static   Arbol b = new Arbol(); ;
     private RandomAccessFile profesorDB;
       private static int numeroRegistros;
     int  numeroregistros;    
     int tamañoregistroString=10;
     
     long  posicionMemoriaArbol=0;  
    
    public ProfesorDAO() throws FileNotFoundException{
      this.profesorDB = new RandomAccessFile("profesor.txt", "rw");
    }
    
    public boolean insertar(Profesor profesor) throws IOException{
        numeroRegistros++;//variable que cuenta el numero de registro
        
        long posicionMemoriaRegistros = this.profesorDB.length();
        b.insertar(profesor.getId(),posicionMemoriaRegistros);
        
        this.profesorDB.seek(posicionMemoriaRegistros);
        this.profesorDB.writeInt(profesor.getId()); //id
    
        for(int i = 0;i < 10; i++){
          
            
          char letra = profesor.getNombre()[i];
          this.profesorDB.writeChar(letra);
        }
        if(profesor.getNombre().length<tamañoregistroString){
        long numdebyte=profesor.getNombre().length-tamañoregistroString;
        this.profesorDB.seek(numdebyte);
            
        }
      
        
        for(int i = 0;i < 10; i++){
          char letra = profesor.getApellido()[i];
          this.profesorDB.writeChar(letra);
        }
        
        if(profesor.getApellido().length<tamañoregistroString){
           
      long numdebyte1=profesor.getApellido().length-tamañoregistroString;
        this.profesorDB.seek(numdebyte1);
         
        }
       
        this.profesorDB.writeInt(profesor.getExt());
        this.profesorDB.writeInt(profesor.getId());
       
        return true;
    }
   
    
   
    
    public boolean borrar( int index) throws IOException{
      Arbol ar=  b.buscar(b, index);
      ar.activo=false;
      this.profesorDB.seek(ar.pos);
      return false;
    }
   
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.profesorDB.length();i= i + 48){
           this.profesorDB.seek(i);
           System.out.println(this.profesorDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.profesorDB.readChar());
           }
           System.out.println("");
           
       
       }
       
     
       
       
       return null;
    }
    
    public void destructor() throws IOException{
      this.profesorDB.close();
    }
    
    
    public void buscar(int index) throws IOException{
        Arbol ar = b.buscar(b, index);
        this.profesorDB.seek(ar.pos);
        this.profesorDB.readLine();
         System.out.println(this.profesorDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.profesorDB.readChar());
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
