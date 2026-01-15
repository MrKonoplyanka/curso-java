package org.irilo.poointerfaces.repositorio.lista;

import org.irilo.poointerfaces.modelo.Producto;
import org.irilo.poointerfaces.repositorio.AbstractListRepositorio;
import org.irilo.poointerfaces.repositorio.Direccion;

import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {
    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }
    @Override
    public List<Producto> ordenar(String campo, Direccion dir) {
        dataSource.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                switch (campo) {
                    case "id" -> resultado = a.getId().compareTo(b.getId());
                    case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
                    case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
                }
            } else if (dir == Direccion.DESC) {
                switch (campo) {
                    case "id" -> resultado = b.getId().compareTo(a.getId());
                    case "descripcion" -> resultado = b.getDescripcion().compareTo(a.getDescripcion());
                    case "precio" -> resultado = b.getPrecio().compareTo(a.getPrecio());
                }
            }
            return resultado;

        });
        return dataSource;
    }

}
