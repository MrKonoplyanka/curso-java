package org.irilo.poointerfaces.repositorio;

import org.irilo.poointerfaces.modelo.Cliente;
import org.irilo.poointerfaces.repositorio.excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoException;
    void crear(T cliente);
    void editar(T cliente) throws AccesoDatoException;
    void eliminar(Integer id) throws AccesoDatoException;

}
