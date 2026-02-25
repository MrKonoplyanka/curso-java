package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuarioSum {
    public static void main(String[] args) {

        IntStream largoNombres = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García","Rocio Carro")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u-> u.toString().length())
                .peek(System.out::println);

        System.out.println(largoNombres.sum());


    }
}
