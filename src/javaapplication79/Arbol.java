package javaapplication79;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria Fernanda
 */
public class Arbol {
    Arbol raiz;
    Arbol izquierda,derecha;
    int info;
    long pos;
    boolean activo;
    
     public Arbol buscar(Arbol arbol, int valor) {
         long b;
        if (arbol.info == valor) {
            if(arbol.activo==true){
            return arbol;    
            }else{
                System.out.println("Inactivo");
            }
            
        } else if (arbol.info > valor) {
            Arbol aux = arbol.izquierda;

            while (aux != null) {
                if (aux.info == valor) {
                    if(aux.activo==true){
                    System.out.println(aux.info);
                    return aux;
                    }else{
                        System.out.println("Registro inactivo");
                    }
                } else if (aux.derecha != null) {
                    aux = aux.derecha;
                } else {
                    aux = aux.izquierda;
                }
            }

        } else if (arbol.info < valor) {
            Arbol aux = arbol.derecha;

            while (aux != null) {

                if (aux.info == valor) {
                    if(aux.activo==true){
                    System.out.println("................" + aux.info);
                    return aux;
                    }else{
                        System.out.println("Registor inactivo");
                    }
                } else if (aux.izquierda != null) {

                    aux = aux.izquierda;
                } else {
                    aux = aux.derecha;
                }
            }
        } else if (arbol == null) {
            return null;
        }
        return null;
    }

     public void insertar (int info,long pos)
      {
          Arbol nuevo;
          nuevo = new Arbol ();
          nuevo.info = info;
          nuevo.pos=pos;
          nuevo.activo=true;
          nuevo.izquierda = null;
          nuevo.derecha = null;
          
          if (raiz == null)
              raiz = nuevo;
          else
          {
              Arbol anterior = null, reco;
              reco = raiz;
              while (reco != null)
              {
                  anterior = reco;
                  if (info < reco.info)
                      reco = reco.izquierda;
                  else
                      reco = reco.derecha;
              }
              if (info < anterior.info)
                  anterior.izquierda = nuevo;
              else
                  anterior.derecha = nuevo;
          }
      } 
}
