package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Iván Rilo","Rocio Carro","Teresa Ferreiro")
                .peek(e-> System.out.println(e))
                .map(nombre -> new Usuario(nombre.split(" ")[0],nombre.split(" ")[1]))
                .map(usuario -> {
                    String nombre = usuario.getNombre().toUpperCase();
                    String apellido = usuario.getApellido().toLowerCase();
                    usuario.setNombre(nombre);
                    usuario.setApellido(apellido);
                    return usuario;
                });

        List<Usuario> lista = nombres.collect(Collectors.toList());
        lista.forEach(System.out::println);
        //nombres.forEach(System.out::println);






    }
}
