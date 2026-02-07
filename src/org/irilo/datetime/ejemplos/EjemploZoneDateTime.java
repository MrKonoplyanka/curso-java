package org.irilo.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class EjemploZoneDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.now();
        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal,newYork);
        System.out.println("zonaNy = " + zonaNy);
        
        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(madrid);
        System.out.println("zonaMadrid = " + zonaMadrid);

        System.out.println("Hora de partida en Ny: " + zonaNy);
        zonaMadrid = zonaNy.withZoneSameInstant(madrid).plusHours(8); // Horas del viaje
        System.out.println("Hora de llegada en Madrid: " + zonaMadrid);
        
    }
}
