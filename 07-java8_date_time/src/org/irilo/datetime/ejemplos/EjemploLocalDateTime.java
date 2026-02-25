package org.irilo.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class EjemploLocalDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaCompleta = LocalDateTime.now();
        System.out.println("fechaCompleta = " + fechaCompleta);

        fechaCompleta = LocalDateTime.of(2020, Month.DECEMBER,24,20,45,59);
        System.out.println("fechaCompleta = " + fechaCompleta);

        fechaCompleta = LocalDateTime.parse("2020-12-25T20:45:59");
        System.out.println("fechaCompleta = " + fechaCompleta);
        LocalDateTime fechaCompletaUnDiaDespues = fechaCompleta.plusDays(1).plusHours(2);
        System.out.println("fechaCompletaUnDiaDespues = " + fechaCompletaUnDiaDespues);
        
        Month mes = fechaCompleta.getMonth();
        System.out.println("mes = " + mes);
        
        int dia = fechaCompleta.getDayOfMonth();
        System.out.println("dia = " + dia);

        int anio = fechaCompleta.getYear();
        System.out.println("anio = " + anio);

        String formato1 = fechaCompleta.format(DateTimeFormatter.ISO_DATE);
        System.out.println("formato1 = " + formato1);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        String formato2 = fechaCompleta.format(df);
        System.out.println("formato2 = " + formato2);

        String formato3 = df.format(fechaCompleta);
        System.out.println("formato3 = " + formato3);

    }
}
