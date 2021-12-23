/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.List;

/**
 * Clase que hace referencia al jugador del Challenge.
 * @author Angie
 */
public class Jugador {
    
    private String nombre;
    private int puntaje;
    private String premio;

    public Jugador(String nombre, int puntaje, String premio) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + ", Puntaje:" + puntaje + ", Premio:" + premio;
    }

    
    
    
    
    
    
}
