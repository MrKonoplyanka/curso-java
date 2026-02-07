package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {

        long count = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .count();


        System.out.println(count);






    }
}
