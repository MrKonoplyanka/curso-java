package org.irilo.api.stream.ejercicios;

import java.util.Arrays;
import java.util.stream.Stream;

public class Tarea31 {

    public static void main(String[] args) {

        String[][] lenguajes = {{"java","groovy"},{"php"},{"c#","python","groovy"},
                {"java","javascript","kotlin"},{"javascript"},{}};

        String[] lenguajesAplanados = Arrays.stream(lenguajes)
                .flatMap(Arrays::stream)
                .distinct()
                .toArray(String[]::new)
                ;
        for(String lenguaje:lenguajesAplanados){
            System.out.println(lenguaje);
        }
    }
}
