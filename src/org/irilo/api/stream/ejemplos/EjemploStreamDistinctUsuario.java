package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García","Rocio Carro")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);


    }
}
