package org.irilo.optional.ejemplo;

import org.irilo.optional.ejemplo.models.Computador;
import org.irilo.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.irilo.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMetodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();
        try{
            Computador pc = repositorio.filtrar("asus grog").orElseThrow(IllegalStateException::new);
            System.out.println(pc);
        }catch (IllegalStateException e){
            System.out.println("Valor defecto");
        }
        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a->a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow();

        System.out.println("extension = " + extension);



    }
}
