package org.irilo.api.stream.ejercicios;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Tarea30 {
    public static void main(String[] args) {
        
        int[] array = {5,1,3,7,6,2};
        
        OptionalInt mayor = IntStream.of(array).max();

        System.out.println("mayor = " + mayor.getAsInt());
        
        
    }
}
