package org.irilo.java.jdbc;


import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;
import org.irilo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.irilo.java.jdbc.repositorio.Repositorio;
import org.irilo.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args)  {
            try(Connection conn = ConexionBaseDatos.getInstance()){

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("========= por id =========");
                System.out.println(repositorio.porId(2L));

                System.out.println("========= editar =========");
                Producto p = new Producto();
                p.setId(4L);
                p.setNombre("Teclado Corsair k95 mecánico");
                p.setPrecio(700);
                Categoria categoria = new Categoria();
                categoria.setId(2L);
                p.setCategoria(categoria);
                repositorio.guardar(p);
                System.out.println("Producto guardado con éxito");
                
                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

