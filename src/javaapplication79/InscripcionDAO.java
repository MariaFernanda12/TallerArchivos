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
public class InscripcionDAO {
           private static  final String path="C:\\Archivos_JAVA\\contacto1.obj";
    public static   Arbol b = new Arbol(); ;
     private RandomAccessFile inscripcionDB;
       private static int numeroRegistros;
     int  numeroregistros;    
     int tamañoregistroString=10;
     
     long  posicionMemoriaArbol=0;  
    
    public InscripcionDAO() throws FileNotFoundException{
      this.inscripcionDB = new RandomAccessFile("profesor.txt", "rw");
    }
    
    public boolean insertar(Inscripcion inscripcion) throws IOException{
        numeroRegistros++;//variable que cuenta el numero de registro
        
        long posicionMemoriaRegistros = this.inscripcionDB.length();
        b.insertar(inscripcion.getIdCurso(),posicionMemoriaRegistros);
        
        this.inscripcionDB.seek(posicionMemoriaRegistros);
        this.inscripcionDB.writeInt(inscripcion.getIdCurso()); //id
        this.inscripcionDB.writeInt(inscripcion.getIdEstudiante());
        this.inscripcionDB.writeInt(inscripcion.getIdCurso());
    
        for(int i = 0;i < 10; i++){
          
            
          char letra = inscripcion.getFechai()[i];
          this.inscripcionDB.writeChar(letra);
        }
        if(inscripcion.getFechai().length<tamañoregistroString){
        long numdebyte=inscripcion.getFechai().length-tamañoregistroString;
        this.inscripcionDB.seek(numdebyte);
            
        }
      
        
        for(int i = 0;i < 10; i++){
          char letra = inscripcion.getFachaf()[i];
          this.inscripcionDB.writeChar(letra);
        }
        
        if(inscripcion.getFachaf().length<tamañoregistroString){
           
      long numdebyte1=inscripcion.getFachaf().length-tamañoregistroString;
        this.inscripcionDB.seek(numdebyte1);
         
        }
       
     this.inscripcionDB.writeDouble(inscripcion.getNota());
        
       
        return true;
    }
   
    
   
    
    public boolean borrar( int index) throws IOException{
      Arbol ar=  b.buscar(b, index);
      ar.activo=false;
      this.inscripcionDB.seek(ar.pos);
      return false;
    }
   
    public ArrayList<Profesor> listarTodo() throws IOException{
       for(long i = 0; i< this.inscripcionDB.length();i= i + 48){
           this.inscripcionDB.seek(i);
           System.out.println(this.inscripcionDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.inscripcionDB.readChar());
           }
           System.out.println("");
           
       
       }
       
     
       
       
       return null;
    }
    
    public void destructor() throws IOException{
      this.inscripcionDB.close();
    }
    
    
    public void buscar(int index) throws IOException{
        Arbol ar = b.buscar(b, index);
        this.inscripcionDB.seek(ar.pos);
        this.inscripcionDB.readLine();
         System.out.println(this.inscripcionDB.readInt());
           for(int j = 0;j<10;j++){
               System.out.print(this.inscripcionDB.readChar());
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
