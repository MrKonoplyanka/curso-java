package org.irilo.patrones.observer.ejemplos;

import org.irilo.patrones.observer.UsuarioRepositorio;

public class EjemploObserver2 {
    public static void main(String[] args) {
        UsuarioRepositorio repo = new UsuarioRepositorio();
        repo.addObserver((observable, obj) -> System.out.println("Enviando email al usuario " + obj));
        repo.addObserver((observable, obj)  -> System.out.println("Enviando email al admin"));
        repo.addObserver((observable, obj)  -> System.out.println("Guardando info del usuario "+obj +" en el log"));
        repo.crearUsuario("Andrés");
    }
}
