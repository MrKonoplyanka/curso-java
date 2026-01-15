package org.irilo.poointerfaces.repositorio;

import org.irilo.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio<T> {
    List<T> ordenar(String campo, Direccion dir);


}
