package org.irilo.patrones.composite;

public class Archivo extends Componente{

    public Archivo(String nombre) {
        super(nombre);
    }

    @Override
    public String mostrar(int nivel) {
        return "\t".repeat(nivel) + getNombre();
    }

    @Override
    public boolean buscar(String nombre) {
        return this.nombre.equalsIgnoreCase(nombre);
    }
}
