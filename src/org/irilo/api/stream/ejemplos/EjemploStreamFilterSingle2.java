package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle2 {
    public static void main(String[] args) {

        Usuario usuario = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .peek(System.out::println)
                .filter(u-> u.getId().equals(3))
                .findFirst().orElseGet(()-> new Usuario("John", "Doe"));


        System.out.println("usuario = " + usuario);






    }
}
