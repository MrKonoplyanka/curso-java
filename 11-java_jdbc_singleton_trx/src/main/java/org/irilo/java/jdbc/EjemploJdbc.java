package org.irilo.java.jdbc;


import org.irilo.java.jdbc.modelo.Categoria;
import org.irilo.java.jdbc.modelo.Producto;
import org.irilo.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.irilo.java.jdbc.repositorio.Repositorio;
import org.irilo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args)  {
            try(Connection conn = ConexionBaseDatos.getInstance()){

                Repositorio<Producto> repositorio = new ProductoRepositorioImpl();

                System.out.println("========= listar =========");
                repositorio.listar().forEach(System.out::println);

                System.out.println("========= por id =========");
                System.out.println(repositorio.porId(2L));

                System.out.println("========= insertar =========");
                Producto p = new Producto();
                p.setNombre("Teclado Red Dragon mecánico");
                p.setPrecio(450);
                p.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(3L);
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

