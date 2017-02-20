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
public class CursoDAO {
       private static  final String path="C:\\Archivos_JAVA\\contacto3.obj";
    public static   Arbol b = new Arbol(); ;
     private RandomAccessFile cursoDB;
       private static int numeroRegistros;
     int  numeroregistros;    
     int tamañoregistroString=10;
     
     long  posicionMemoriaArbol=0;  
    
    public CursoDAO() throws FileNotFoundException{
      this.cursoDB = new RandomAccessFile("profesor.txt", "rw");
    }
    
    public boolean insertar(Curso curso) throws IOException{
        numeroRegistros++;//variable que cuenta el numero de registro
        
        long posicionMemoriaRegistros = this.cursoDB.length();
        b.insertar(curso.getId(),posicionMemoriaRegistros);
        
        this.cursoDB.seek(posicionMemoriaRegistros);
        this.cursoDB.writeInt(curso.getId()); //id
    
        for(int i = 0;i < 10; i++){
          
            
          char letra = curso.getNombre()[i];
          this.cursoDB.writeChar(letra);
        }
        if(curso.getNombre().length<tamañoregistroString){
        long numdebyte=curso.getNombre().length-tamañoregistroString;
        this.cursoDB.seek(numdebyte);
            
        }
      
        
       
       
        this.cursoDB.writeInt(curso.getDuracion());
        this.cursoDB.writeInt(curso.getId());
        this.cursoDB.writeInt(curso.getIdprofesor());
       
        return true;
    }
   
    
   
    
    public boolean borrar( int index) throws IOException{
      Arbol ar=  b.buscar(b, index);
      ar.activo=false;
      this.cursoDB.seek(ar.pos);
      return false;
    }
   
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.cursoDB.length();i= i + 48){
           this.cursoDB.seek(i);
           System.out.println(this.cursoDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.cursoDB.readChar());
           }
           System.out.println("");
           
       
       }
       
     
       
       
       return null;
    }
    
    public void destructor() throws IOException{
      this.cursoDB.close();
    }
    
    
    public void buscar(int index) throws IOException{
        Arbol ar = b.buscar(b, index);
        this.cursoDB.seek(ar.pos);
        this.cursoDB.readLine();
         System.out.println(this.cursoDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.cursoDB.readChar());
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
