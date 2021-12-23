package clases;


import procesamientoArchivo.Leer;
import clases.Pregunta;
import clases.Respuesta;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import listaDinamica.ListaDinamica;

/**
 * Clase controladora principal del juego, en la que se realizan
 * las validaciones de las preguntas con sus respectivas respuestas y  los 
 * puntos totales.
 * @author Angie
 */

public class Test {

    //atributos
    private ListaDinamica<Pregunta> preguntas;
    private int puntosTotales;
    private int preguntaActual;

    //Constructor
    public Test() {
        preguntas = new ListaDinamica<>();
        puntosTotales = 0;
        preguntaActual = 0;
    }

    //Getter
    public ListaDinamica<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }

    public Pregunta siguientePregunta() {

        //cojo la siguiente pregunta
        Pregunta p = preguntas.get(preguntaActual);

        //si la pregunta es distinto de null, paso la siguiente
        if (p != null) {
            preguntaActual++;
        }

        return p;

    }

    /**
     * Se reinicia el test, poniendo la pregunta y puntos en cero.
     */
    public void reiniciarTest() {
        preguntaActual = 0;
        puntosTotales = 0;
    }

    
    /**
     * Inicializa el test, aumentando puntos si acierta o reiniciando el test
     * en caso de que falle.
     * @param preguntasT preguntas escogidas aleatoriamente de cada categoria
     */
    public void realizarTest(ListaDinamica<Pregunta> preguntasT) {

        //si estan vacias las preguntas, no hacemos nada
        if (preguntasT.isEmpty()) {
            System.out.println("No hay preguntas");
        } else {

            //Creamos un objeto leer
            Leer teclado = new Leer();

            int i = 0, respuesta;
            Pregunta p;

            //recorremos las preguntas
            while (i < preguntasT.size()) {

                //Cojemos una pregunta
                p = preguntasT.get(i);
                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta = teclado.pedirIntRango(1, p.getRespuestas().size(), 
                        "Introduce la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta)) {
                    System.out.println("Has acertado :)");
                    puntosTotales += p.getPuntos();
                } else {
                    
                    System.out.println("No has acertado :(");
                    System.out.println("\n---Reinicio del juego-- ");
                    reiniciarTest();
                    realizarTest(preguntasT);
                }

                i++;
            }

        }

        //muestro los puntos
        System.out.println("Has obtenido " + puntosTotales + " puntos");

    }
    
    
    /**
     * Se carga la información de una ruta, en este caso las preguntas.
     * Verifica si es una pregunta o una respuesta según como inicia y se agrega
     * a una lista según corresponda. Además se crean sus respectivos objetos.
     * @param fichero Ruta ingresada
     * @return Lista con las preguntas encontradas en el fichero
     * @throws FileNotFoundException Lanza exception en caso de que no se 
     * encuentre el archivo.
     * @throws IOException 
     */
    public ListaDinamica<Pregunta> cargarFichero(String fichero) throws 
            FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        //variables necesarias
        String linea;
        Pregunta p;
        ListaDinamica<Respuesta> respuestas = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea = br.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea.startsWith(";P;")) {
                    texto_pregunta = linea.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea.startsWith(";R;")) {
                    opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, cojo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, cojo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas.addLast(new Respuesta(linea));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos sean 4
                if (pregunta && respuesta && puntos && (respuestas.size() == 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p = new Pregunta(texto_pregunta, respuestas, puntosPregunta);

                    //añado la pregunta
                    preguntas.addLast(p);

                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas = new ListaDinamica<>();
            }

        }

        br.close();
        return preguntas;
    }
    
    /**
     * Se asigna el premio según el puntaje obtenido en el juego
     * @param puntaje Puntaje obtenido en el juego
     */
    public String asignarPremio(int puntaje){
        String premio ="";
        if(puntaje == 150){
            premio ="Oro"; 
        }
        else if(puntaje >= 100 && puntaje < 140){
           premio ="Plata"; 
        }
        else if(puntaje >= 50 && puntaje <= 90){
           premio ="Bronce"; 
        }
        else if(puntaje == 0){
           premio ="No hay premio"; 
        }
        return premio;
         
    }

}
