package org.irilo.optional.ejemplo;

import org.irilo.optional.ejemplo.models.Computador;
import org.irilo.optional.ejemplo.models.Fabricante;
import org.irilo.optional.ejemplo.models.Procesador;
import org.irilo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.irilo.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        String fab = repositorio.filtrar("asus rog")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .map(Fabricante::getNombre)
                .orElse("Desconocido");
        System.out.println(fab);




    }
}
