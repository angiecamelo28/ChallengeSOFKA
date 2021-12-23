/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package procesamientoArchivo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Angie
 */
public class Escribir {

    public void escribirArchivo(String informacion) throws Exception {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src//Historico//Historico.txt",true);
            pw = new PrintWriter(fichero);
            //Escribe la información que le ingresa
            pw.println(informacion+"\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el fichero.
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
