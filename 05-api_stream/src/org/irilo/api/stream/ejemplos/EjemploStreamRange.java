package org.irilo.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        IntStream num = IntStream.range(5,20);

        //Integer resultado = num.sum();
        IntSummaryStatistics stats = num.summaryStatistics();
        System.out.println(stats);
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }

}
