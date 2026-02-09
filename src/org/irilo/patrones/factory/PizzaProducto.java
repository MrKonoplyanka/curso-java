package org.irilo.patrones.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaProducto {

    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public PizzaProducto() {
        this.ingredientes = new ArrayList<>();
    }

    public void preparar(){
        System.out.println("Preparando: " + nombre);
        System.out.println("Seleccionando masa: " + masa);
        System.out.println("Agregando salsa: " + salsa);
        System.out.println("Agregando ingredientes: ");
        this.ingredientes.forEach(System.out::println);

    }

    abstract public void cocinar();
    abstract public void cortar();

    public void empaquetar(){
        System.out.println("Poniendo la pizza en una caja");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "PizzaProducto{" +
                "nombre='" + nombre + '\'' +
                ", masa='" + masa + '\'' +
                ", salsa='" + salsa + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
