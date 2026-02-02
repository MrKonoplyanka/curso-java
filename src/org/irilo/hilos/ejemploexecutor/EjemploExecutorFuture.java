package org.irilo.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = ()-> {
            System.out.println("Inicio de la tarea...");
            System.out.println("Nombre del thread" + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Algún resultado de la tarea...";
        };
        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main ...");
        while (!resultado.isDone()){
            System.out.println("ejecutando tarea...");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Resultado de la tarea: " +resultado.get(2,TimeUnit.SECONDS));
        System.out.println("Finaliza la tarea: " + resultado.isDone());;


    }
}

