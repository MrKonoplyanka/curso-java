package org.irilo.java.jdbc.service;

import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;
import org.irilo.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.irilo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.irilo.java.jdbc.repositorio.Repositorio;
import org.irilo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatalogoServicio implements Service{

    private Repositorio<Producto> productoRepositorio;
    private Repositorio<Categoria> categoriaRepositorio;

    public CatalogoServicio() {
        this.productoRepositorio = new ProductoRepositorioImpl();
        this.categoriaRepositorio = new CategoriaRepositorioImpl();
    }

    @Override
    public List<Producto> listar() throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.listar();
        }

    }

    @Override
    public Producto porId(Long id) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            return productoRepositorio.porId(id);
        }
    }

    @Override
    public Producto guardar(Producto p) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Categoria> listarCategoria() throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.listar();
        }

    }

    @Override
    public Categoria guardarCategoria(Categoria c) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Categoria porIdCategoria(Long id) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            return categoriaRepositorio.porId(id);
        }

    }

    @Override
    public void eliminarCategoria() throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void guardarProductoConCategoria(Producto p, Categoria c) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getConnection()){
            productoRepositorio.setConn(conn);
            categoriaRepositorio.setConn(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {
                conn.commit();

            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }
    }

}
