package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {

        long count = Stream
                .of("Iván Rilo","","Rocio Carro","","Teresa Ferreiro","Iván García")                
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();

        System.out.println("count = " + count);
       






    }
}
