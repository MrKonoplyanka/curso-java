package org.irilo.java.jdbc.service;

import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;

import java.sql.SQLException;
import java.util.List;

public interface Service {
    List<Producto> listar() throws SQLException;

    Producto porId(Long id)throws SQLException;

    Producto guardar(Producto p)throws SQLException;

    void eliminar(Long id)throws SQLException;

    List<Categoria> listarCategoria() throws SQLException;

    Categoria guardarCategoria(Categoria c) throws SQLException;

    Categoria porIdCategoria(Long id) throws SQLException;

    void eliminarCategoria() throws SQLException;

    void guardarProductoConCategoria(Producto p, Categoria c ) throws SQLException;
}
