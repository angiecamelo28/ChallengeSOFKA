package procesamientoArchivo;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Clase para gestionar entrada de datos y validaciones
 * @author Angie Camelo
 */
public class Leer {

    //Scanner para pedir datos
    private Scanner sc;

    /**
     * Por defecto
     */
    public Leer() {
        sc = new Scanner(System.in);
        sc.useDelimiter("\n"); //Usado para nextLine()
        sc.useLocale(Locale.US); // Para double
    }

    
    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println("Introduce un numero integer entre " + minimo
                        + " y " + maximo);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " +
                        minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " +
                        minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    /**
     * Pide un numero entre dos numeros que le pasamos
     *
     * @param minimo
     * @param maximo
     * @param mensaje
     * @param mensajeError
     * @return numero entero introducido por el usuario
     */
    public int pedirIntRango(int minimo, int maximo, String mensaje, String 
            mensajeError) {
        int num;

        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println(mensajeError);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }
}
