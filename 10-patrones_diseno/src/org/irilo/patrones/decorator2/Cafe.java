package org.irilo.patrones.decorator2;

public class Cafe implements Configurable{

    private float precio;
    private String nombre;

    public Cafe(float precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    @Override
    public float getPrecioBase() {
        return this.precio;
    }

    @Override
    public String getIngredientes() {
        return this.nombre;
    }
}
