package procesamientoArchivo;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *Clase para escribir o sobreescribir información en archivo de texto.
 * @author Angie
 */
public class Escribir {

    /**
     * Por medio del File y Print Wirter se recorre un archivo de texto
     * y se escribe o sobreescribe información ingresada.
     * @param informacion
     * @throws Exception 
     */
    public void escribirArchivo(String informacion) throws Exception {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("src//Historico//Historico.txt",true);
            pw = new PrintWriter(fichero);
            //Escribe la información que le ingresa
            pw.println(informacion);

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
