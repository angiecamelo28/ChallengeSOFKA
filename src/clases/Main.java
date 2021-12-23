
package clases;

import java.io.IOException;
import java.util.Random;
import listaDinamica.ListaDinamica;

/**
 *
 * @author Angie
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        
      //Creación de objetos
      Test t1=new Test();
      Test t2=new Test();
      Test t3=new Test();
      Test t4=new Test();
      Test t5=new Test();
      Test test=new Test();
      
      //Carga preguntas
      ListaDinamica<Pregunta> pExtraF = t1.cargarFichero("src\\datosPreguntas\\ExtraFacil.txt");
      ListaDinamica<Pregunta> pFaciles = t2.cargarFichero("src\\datosPreguntas\\Facil.txt");
      ListaDinamica<Pregunta> pMedio = t3.cargarFichero("src\\datosPreguntas\\Medio.txt");
      ListaDinamica<Pregunta> pDificil = t4.cargarFichero("src\\datosPreguntas\\Dificil.txt");
      ListaDinamica<Pregunta> pExtremo = t5.cargarFichero("src\\datosPreguntas\\Extremo.txt");
      ListaDinamica<Pregunta> pT = new ListaDinamica<>();
      
      //Añadiendo a la lista
      pT.addLast(pExtraF.get((int) ((Math.random() * 4))));
      pT.addLast(pFaciles.get((int) ((Math.random() * 4))));
      pT.addLast(pMedio.get((int) ((Math.random() * 4))));
      pT.addLast(pDificil.get((int) ((Math.random() * 4))));
      pT.addLast(pExtremo.get((int) ((Math.random() * 4))));
      
   
        System.out.println("-----Preguntas--------");
        test.realizarTest(pT);
      
    }
    
    
    
}
