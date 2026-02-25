package org.irilo.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres = Stream
                .of("Iván Rilo", "Rocio Carro", "Teresa Ferreiro", "Iván García", "Rocio Carro", "Rocio Carro")
                        .distinct();

        String resultado = nombres.reduce("Resultado concat ", (a,b)-> a+ ", " +b);
        System.out.println(resultado);
    }

}
