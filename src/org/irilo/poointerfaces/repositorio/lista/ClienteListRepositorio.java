package org.irilo.poointerfaces.repositorio.lista;

import org.irilo.poointerfaces.modelo.Cliente;
import org.irilo.poointerfaces.repositorio.AbstractListRepositorio;
import org.irilo.poointerfaces.repositorio.Direccion;

import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {


    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }


    @Override
    public List<Cliente> ordenar(String campo, Direccion dir) {
        dataSource.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
                }
            } else if (dir == Direccion.DESC) {
                switch (campo) {
                    case "id" -> resultado = b.getId().compareTo(a.getId());
                    case "nombre" -> resultado = b.getNombre().compareTo(a.getNombre());
                    case "apellido" -> resultado = b.getApellido().compareTo(a.getApellido());
                }
            }
            return resultado;

        });
        return dataSource;
    }


}
