package org.irilo.patrones.observer.ejemplos;

import org.irilo.patrones.observer.Corporacion;

public class EjemploObserver {
    public static void main(String[] args) {

        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver((observable, obj)  -> {
            System.out.println("John: " + observable);
        });
        google.addObserver((observable, obj)  -> {
            System.out.println("Andrés: " + observable);
        });

        google.modificaPrecio(500);
    }
}