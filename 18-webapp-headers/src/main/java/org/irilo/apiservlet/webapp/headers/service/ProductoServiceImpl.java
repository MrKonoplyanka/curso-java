package org.irilo.apiservlet.webapp.headers.service;

import org.irilo.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(
                new Producto(1L,"notebook","computación", 175000),
                new Producto(2L,"mesa escritorio","oficina", 10000),
                new Producto(3L,"teclado mecánico","computación", 40000)

        );
    }
}
