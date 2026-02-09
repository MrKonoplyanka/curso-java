package org.irilo.recursividad.ejemplo;

import org.irilo.recursividad.ejemplo.models.Componente;

import java.util.stream.Stream;

public class EjemploRecursividad {
    public static void main(String[] args) {
        Componente pc = new Componente("Gabinete PC ATX");
        Componente fuenteAlimentacion = new Componente("Fuente de alimentación 700w");
        Componente placaBase = new Componente("MainBoard Asus Sockets AMD");
        Componente procesador = new Componente("CPU AMD Ryzen 5 2800");
        Componente ventilador = new Componente("Ventilador CPU");
        Componente disipador = new Componente("Disipador");
        Componente tarjetaGrafica = new Componente("Nvidia RTX 3080 8gb");
        Componente gpu = new Componente("Nvidia GPU RTX");
        Componente gpuRam = new Componente("4gb Ram");
        Componente gpuRam2 = new Componente("4gb Ram");
        Componente gpuVentiladores = new Componente("Ventiladores");
        Componente ram = new Componente("Memoria Ram 32gb");
        Componente ssd = new Componente("Disco SSD 2T");

        procesador.addComponente(ventilador)
                .addComponente(disipador);
        tarjetaGrafica.addComponente(gpu)
                .addComponente(gpuRam)
                .addComponente(gpuRam2)
                .addComponente(gpuVentiladores);
        placaBase.addComponente(procesador)
                .addComponente(tarjetaGrafica)
                .addComponente(ram)
                .addComponente(ssd);
        pc.addComponente(fuenteAlimentacion)
                .addComponente(placaBase)
                .addComponente(new Componente("Teclado"))
                .addComponente(new Componente("Ratón"));

        metodoRecursivoJava8(pc,0).forEach(c-> System.out.println("-".repeat(c.getNivel())+c.getNombre()));
    }
    public static Stream<Componente> metodoRecursivoJava8(Componente c, int nivel){
       c.setNivel(nivel);
       return Stream.concat(Stream.of(c),
               c.getHijos().stream().flatMap(hijo -> metodoRecursivoJava8(hijo,nivel+1)));

    }
    public static void metodoRecursivo(Componente c, int nivel){
        System.out.println("-".repeat(nivel) + c.getNombre());
        if(c.tieneHijos()){
            for (Componente hijo: c.getHijos()){
                metodoRecursivo(hijo,nivel+1);
            }
        }
    }
}
