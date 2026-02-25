package org.irilo.hilos.ejemplos;

import org.irilo.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Robinson Crusoe")).start();
        new Thread(new ViajeTarea("Juan Fernández")).start();
        new Thread(new ViajeTarea("Isla de Chiloe")).start();
    }
}
