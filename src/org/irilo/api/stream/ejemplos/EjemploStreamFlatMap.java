package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFlatMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Pepe García")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .flatMap(u-> {
                    if(u.getNombre().equalsIgnoreCase("Pepe")){
                        return Stream.of(u);
                    }
                    return Stream.empty();

                })
                .peek(System.out::println);


        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);






    }
}
