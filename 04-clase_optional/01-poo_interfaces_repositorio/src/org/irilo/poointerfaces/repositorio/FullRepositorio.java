package org.irilo.poointerfaces.repositorio;

public interface FullRepositorio<T> extends CrudRepositorio<T>,OrdenableRepositorio<T>
        ,PaginableRepositorio<T>,ContableRepositorio{
}
