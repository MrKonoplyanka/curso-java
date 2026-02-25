package org.irilo.hilos.ejemploexecutor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        System.out.println("Tamaño del pool:" +executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola; " +executor.getQueue().size());

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
        Callable<Integer> tarea2 = () ->{
            System.out.println("Iniciando tarea 3...");
            TimeUnit.SECONDS.sleep(3);
            return 10;
        };
        Future<String> resultado = executor.submit(tarea);
        Future<String> resultado2 = executor.submit(tarea);
        Future<Integer> resultado3 = executor.submit(tarea2);

        System.out.println("Tamaño del pool:" +executor.getPoolSize());
        System.out.println("Cantidad de tareas en cola; " +executor.getQueue().size());

        executor.shutdown();
        System.out.println("Continuando con la ejecución del método main ...");
        while (!(resultado.isDone() & resultado2.isDone() & resultado3.isDone())){
            System.out.println(String.format("resultado1: %s - resultado2: %s -resultado3: %s"
                    ,resultado.isDone()? "finalizó" : "en proceso"
                    ,resultado2.isDone()? "finalizó" : "en proceso"
                    ,resultado3.isDone()? "finalizó" : "en proceso"));

            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("Resultado de la tarea1: " +resultado.get(2,TimeUnit.SECONDS));
        System.out.println("Resultado de la tarea2: " +resultado2.get(2,TimeUnit.SECONDS));
        System.out.println("Resultado de la tarea3: " +resultado3.get(2,TimeUnit.SECONDS));
        System.out.println("Finaliza la tarea: " + resultado.isDone());;


    }
}

