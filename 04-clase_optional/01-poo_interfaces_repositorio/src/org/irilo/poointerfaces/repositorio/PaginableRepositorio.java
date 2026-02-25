package org.irilo.poointerfaces.repositorio;

import org.irilo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio<T> {
    List<T> listar (int desde, int hasta);

}
