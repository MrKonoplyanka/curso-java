package org.irilo.hilos.ejemplos;

import org.irilo.hilos.ejemplos.threads.NombreThread;

public class EjemploExtenderThread {

    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("John Doe");
        hilo.start();
        //Thread.sleep(100);
        Thread hilo2 = new NombreThread("María");
        hilo2.start();

        Thread hilo3 = new NombreThread("Pepe");
        hilo3.start();
        System.out.println(hilo.getState());

    }


}
