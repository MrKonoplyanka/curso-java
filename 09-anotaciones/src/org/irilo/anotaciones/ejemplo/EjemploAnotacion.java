package org.irilo.anotaciones.ejemplo;

import org.irilo.anotaciones.ejemplo.models.Producto;
import org.irilo.anotaciones.ejemplo.procesador.JsonSerializador;
import java.time.LocalDate;

public class EjemploAnotacion {
    public static void main(String[] args) {
        Producto p = new Producto();
        p.setFecha(LocalDate.now());
        p.setNombre("mesa CENTRO roble");
        p.setPrecio(1000l);


        String json = JsonSerializador.convertirJson(p);

        System.out.println("json = " + json);

    }
}
