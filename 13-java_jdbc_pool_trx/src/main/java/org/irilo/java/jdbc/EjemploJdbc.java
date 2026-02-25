package org.irilo.java.jdbc;


import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;
import org.irilo.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.irilo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.irilo.java.jdbc.repositorio.Repositorio;
import org.irilo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        try(Connection conn = ConexionBaseDatos.getConnection()){

            Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
            if (conn.getAutoCommit()){
                conn.setAutoCommit(false);
            }
            try {

            Categoria categoria = new Categoria();
            categoria.setCategoria("ElectroHogar");
            categoria = repositorioCategoria.guardar(categoria);
            System.out.println("Categoría guardada con éxito " +categoria.getId());

            System.out.println("========= listar =========");
            repositorio.listar().forEach(System.out::println);

            System.out.println("========= por id =========");
            System.out.println(repositorio.porId(2L));

            System.out.println("========= insertar =========");
            Producto p = new Producto();
            p.setNombre("Refrigerador Samsung");
                p.setPrecio(9900);
                p.setFechaRegistro(new Date());
                p.setCategoria(categoria);
                p.setSku("def123456");
                p = repositorio.guardar(p);
                System.out.println("Producto guardado con éxito " +p.getId());

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

                conn.commit();
            }catch (SQLException e){
                conn.rollback();
                e.printStackTrace();
            }
        }

    }
    }

