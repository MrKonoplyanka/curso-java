package org.irilo.java.jdbc;


import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;
import org.irilo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.irilo.java.jdbc.repositorio.Repositorio;
import org.irilo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTrx {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConexionBaseDatos.getInstance()) {

            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }
            try {

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("========= por id =========");
                System.out.println(repositorio.porId(2L));

                System.out.println("========= insertar =========");
                Producto p = new Producto();
                p.setNombre("Teclado IBM mecánico 2");
                p.setPrecio(1450);
                p.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
                p.setCategoria(categoria);
                p.setSku("abcde12345");
                repositorio.guardar(p);
                System.out.println("Producto guardado con éxito");

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("========= editar =========");
                p.setId(4L);
                p.setNombre("Teclado Corsair k95 mecánico");
                p.setPrecio(1000);
                p.setSku("abcde123456");
                categoria.setId(2L);
                p.setCategoria(categoria);
                repositorio.guardar(p);
                System.out.println("Producto guardado con éxito");

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);
                conn.commit();
            } catch (SQLException ex) {
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}

