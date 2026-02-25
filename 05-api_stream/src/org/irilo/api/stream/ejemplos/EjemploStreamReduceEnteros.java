package org.irilo.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduceEnteros {
    public static void main(String[] args) {

        Stream<Integer> nombres = Stream
                .of(5,10,15,20);


        Integer resultado = nombres.reduce(0, (a,b)-> a+b);
        System.out.println(resultado);
    }

}
