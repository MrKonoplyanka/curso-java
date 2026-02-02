package org.irilo.java8.lamba;

import org.irilo.java8.lamba.models.Usuario;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EjemploConsumer {
    public static void main(String[] args) {
        Consumer<Date> consumidor = fecha -> {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(f.format(fecha));
        };
        consumidor.accept(new Date());

        BiConsumer<String,Integer> consumidorBi = (nombre, edad) -> {
            System.out.println(nombre + ", tiene " +edad+ " años!");
        };

        consumidorBi.accept("Pepe",30);

        Consumer<String> consumidor2 = System.out::println;
        consumidor2.accept("Hola Mundo");

        List<String> nombres = Arrays.asList("Andrés","Pepe","Luz","Paco");
        nombres.forEach(consumidor2);
        Usuario usuario = new Usuario();

        BiConsumer<Usuario,String> asignarNombre = Usuario::setNombre;
        asignarNombre.accept(usuario,"Andrés");
        System.out.println("Nombre: " + usuario.getNombre());

        Supplier<String> proveedor = () -> "Hola Mundo Lamba Supplier";

        System.out.println(proveedor.get());
        Supplier<Usuario> creaUsuario = Usuario::new;
        Usuario usuario2 = creaUsuario.get();

    }
}
