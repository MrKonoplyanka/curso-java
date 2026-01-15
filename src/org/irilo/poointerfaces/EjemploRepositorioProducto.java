package org.irilo.poointerfaces;

import org.irilo.poointerfaces.modelo.Cliente;
import org.irilo.poointerfaces.modelo.Producto;
import org.irilo.poointerfaces.repositorio.Direccion;
import org.irilo.poointerfaces.repositorio.FullRepositorio;
import org.irilo.poointerfaces.repositorio.lista.ClienteListRepositorio;
import org.irilo.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
        FullRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 50.52));
        repo.crear(new Producto("silla", 18));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 400.89));
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);

        System.out.println("===== Paginable =====");
        List<Producto> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("===== Ordenar =====");
        List<Producto> productosOrdenAsc = repo.ordenar("descripcion", Direccion.ASC);
        productosOrdenAsc.forEach(System.out::println);

        System.out.println("===== Editar =====");
        Producto tvActualizar = new Producto("tv", 600.42);
        tvActualizar.setId(2);
        repo.editar(tvActualizar);
        repo.listar().forEach(System.out::println);

        System.out.println("===== Eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("Total registros: " + repo.total());
    }
}
