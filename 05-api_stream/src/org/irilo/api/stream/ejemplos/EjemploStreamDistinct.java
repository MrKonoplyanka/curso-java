package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinct {
    public static void main(String[] args) {

        Stream<String> nombres = Stream
                .of("Iván Rilo", "Rocio Carro", "Teresa Ferreiro", "Iván García", "Rocio Carro", "Rocio Carro")
                        .distinct();

        nombres.forEach(System.out::println);
    }

}
