package org.irilo.api.stream.ejercicios;

import java.sql.Array;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tarea29 {
    public static void main(String[] args) {

        double suma = IntStream.rangeClosed(1,100)
                .filter(n-> n%10 !=0)
                .mapToDouble((n)-> (double) n /2)
                .reduce(0, (acum,val)-> acum+val);

        System.out.println("suma = " + suma);

    }
}
