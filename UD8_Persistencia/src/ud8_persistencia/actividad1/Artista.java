/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud8_persistencia.actividad1;

/**
 *
 * @author 1DAW2425-09
 */

import javax.persistence.Embeddable;

@Embeddable
public class Artista {
    private String nombre;

    public Artista() {} 

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}


