/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 *
 * @author Angie
 */
public class Jugador {
    
    private String nombre;
    private int puntaje;
    private List<String> premios;

    public Jugador(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", puntaje=" + puntaje ;
    }
    
    
}
