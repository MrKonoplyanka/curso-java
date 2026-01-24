package org.irilo.poointerfaces.repositorio;


import org.irilo.poointerfaces.modelo.BaseEntity;
import org.irilo.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListRepositorio<T extends BaseEntity> implements FullRepositorio<T> {

    protected List<T> dataSource;

    public AbstractListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.dataSource;
    }

    @Override
    public T porId(Integer id) throws LecturaAccesoDatoException {
        if (id==null || id <= 0){
            throw new LecturaAccesoDatoException("Id inválido");
        }
        T resultado = null;
        for(T t:dataSource){
            if(t.getId().equals(id)){
                resultado = t;
                break;
            }
        }

        return resultado;
    }

    @Override
    public void crear(T t) {
        this.dataSource.add(t);
    }


    @Override
    public void eliminar(Integer id) throws LecturaAccesoDatoException {

        this.dataSource.remove(this.porId(id));
    }


    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }
}
