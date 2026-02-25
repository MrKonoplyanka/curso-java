package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro","Iván García")
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .filter(u-> u.getNombre().equals("Iván"))
                .peek(System.out::println);


        Optional<Usuario> usuario = nombres.findFirst();
        //System.out.println(usuario.orElse(new Usuario("John","Doe")));
        //System.out.println(usuario.orElseGet(() -> new Usuario("John","Doe")));
        //System.out.println(usuario.orElseThrow());
        if(usuario.isPresent()){
            System.out.println(usuario);
        }
        else {
            System.out.println("No existe");
        }
        //nombres.forEach(System.out::println);






    }
}
