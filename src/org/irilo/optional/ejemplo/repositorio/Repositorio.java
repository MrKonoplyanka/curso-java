package org.irilo.optional.ejemplo.repositorio;

import org.irilo.optional.ejemplo.models.Computador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computador> filtrar(String nombre);
}
