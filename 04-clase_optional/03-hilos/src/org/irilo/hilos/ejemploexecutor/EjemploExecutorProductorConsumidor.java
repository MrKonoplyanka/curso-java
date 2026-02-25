package org.irilo.hilos.ejemploexecutor;

import org.irilo.hilos.ejemplosync.Panaderia;
import org.irilo.hilos.ejemplosync.runnable.Consumidor;
import org.irilo.hilos.ejemplosync.runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorProductorConsumidor {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool:" +executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola; " +executor.getQueue().size());

        Panaderia p = new Panaderia();

        Runnable productor = new Panadero(p);
        Runnable consumidor = new Consumidor(p);


        Future<?> futuro1 = executor.submit(productor);
        Future<?> futuro2 = executor.submit(consumidor);


        System.out.println("Tamaño del pool:" +executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola; " +executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main ...");



    }
}

