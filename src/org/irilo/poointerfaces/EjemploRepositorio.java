package org.irilo.poointerfaces;

import org.irilo.poointerfaces.modelo.Cliente;
import org.irilo.poointerfaces.repositorio.*;
import org.irilo.poointerfaces.repositorio.excepciones.AccesoDatoException;
import org.irilo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.irilo.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            
        FullRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "González"));
        repo.crear(new Cliente("Luci", "Martínez"));
        repo.crear(new Cliente("Andrés", "Guzmán"));
        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);

        System.out.println("===== Paginable =====");
        List<Cliente> paginable = repo.listar(1, 3);
        paginable.forEach(System.out::println);

        System.out.println("===== Ordenar =====");
        List<Cliente> clientesOrdenAsc = repo.ordenar("nombre", Direccion.ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("===== Editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        repo.listar().forEach(System.out::println);

        System.out.println("===== Eliminar =====");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);

        System.out.println("Total registros: " + repo.total());
        }catch (LecturaAccesoDatoException e){
            System.out.println("e = " + e);
            e.printStackTrace();
        }catch (AccesoDatoException e){
            System.out.println("e = " + e);
        }
    }
}
