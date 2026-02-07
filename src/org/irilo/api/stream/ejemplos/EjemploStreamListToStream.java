package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {
        List<Usuario> lista = new ArrayList<>();
        lista.add(new Usuario("Andrés","Guzmán"));
        lista.add(new Usuario("Pepe","Martinez"));
        lista.add(new Usuario("Iván","Rilo"));
        lista.add(new Usuario("Rocío","Carro"));
        lista.add(new Usuario("Alejandro","Rilo"));

        lista.stream().map(u-> u.getNombre().toUpperCase()
                .concat(" ").concat(u.getApellido().toUpperCase()))
                .flatMap(nombre ->{
                    if(nombre.contains("pepe".toUpperCase())){
                        return Stream.of(nombre);
                    }
                    else{
                        return Stream.empty();
                    }
                })
                .forEach(System.out::println);



    }
}
