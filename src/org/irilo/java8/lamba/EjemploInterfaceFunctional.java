package org.irilo.java8.lamba;

import org.irilo.java8.lamba.aritmetica.Aritmetica;
import org.irilo.java8.lamba.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {

        Aritmetica suma = (a,b) -> a+b;
        Aritmetica resta = (a,b) -> a-b;

        Calculadora cal = new Calculadora();

        System.out.println(cal.computar(10,5,suma));
        System.out.println(cal.computar(10,5,resta));
        System.out.println(cal.computar(10,5 ,(a,b)->a*b));

        System.out.println(cal.computarConBiFunction(10,5, (a,b)->a+b));

    }
}
