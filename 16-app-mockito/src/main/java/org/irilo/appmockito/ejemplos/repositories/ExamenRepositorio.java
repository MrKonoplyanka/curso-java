package org.irilo.appmockito.ejemplos.repositories;

import org.irilo.appmockito.ejemplos.models.Examen;

import java.util.List;

public interface ExamenRepositorio {
    List<Examen> findAll();
    Examen guardar(Examen examen);
}
