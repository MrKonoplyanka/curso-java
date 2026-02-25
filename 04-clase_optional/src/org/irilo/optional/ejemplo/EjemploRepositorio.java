package org.irilo.optional.ejemplo;

import org.irilo.optional.ejemplo.models.Computador;
import org.irilo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.irilo.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Optional<Computador> pc = repositorio.filtrar("asus og");

        pc.ifPresentOrElse((c)-> System.out.println("Marca: " + c.getNombre()),
                ()-> System.out.println("No se encontró con ese nombre"));
    }
}
