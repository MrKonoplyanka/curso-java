package org.irilo.ejemplos.modelo;

import java.util.Objects;

public class Alumno implements Comparable<Alumno> {
    private String nombre;
    private Integer nota;

    public Alumno(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nombre +
                ", nota=" + nota;
    }


    @Override
    public int compareTo(Alumno a) {
        if(this.nota==null){
            return 0;
        }
        return this.nota.compareTo(a.nota);
    }
}
