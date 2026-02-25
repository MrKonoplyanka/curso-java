package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterAnyMatch {
    public static void main(String[] args) {

        Boolean existe = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .anyMatch(u-> u.getId().equals(3));


        System.out.println(existe);






    }
}
