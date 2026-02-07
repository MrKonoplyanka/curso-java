package org.irilo.optional.ejemplo;

import org.irilo.optional.ejemplo.models.Computador;
import org.irilo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.irilo.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador defecto = new Computador("defecto","defecto");
        Computador pc = repositorio.filtrar("asuss rog").orElse(defecto);
        System.out.println(pc);

        pc = repositorio.filtrar("macbook").orElseGet(()->{
            Computador defecto2 = new Computador("DEFECTO2","DEFECTO2");
            return defecto2;
        });
        System.out.println(pc);


    }
}
