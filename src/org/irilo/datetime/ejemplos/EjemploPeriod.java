package org.irilo.datetime.ejemplos;


import java.time.LocalDate;
import java.time.Period;

public class EjemploPeriod {
    public static void main(String[] args) {

        LocalDate fecha1 = LocalDate.of(2011,9,23);
        LocalDate fecha2 = LocalDate.of(2020,11,25);
        fecha2 = fecha2.withMonth(12);

        Period period = Period.between(fecha1,fecha2);
        System.out.println("period = " + period);
        System.out.printf("Periodo entre %s y %s hay %d años, %d meses, %d dias",
                fecha1,fecha2,period.getYears(),period.getMonths(),period.getDays());
    }
}
