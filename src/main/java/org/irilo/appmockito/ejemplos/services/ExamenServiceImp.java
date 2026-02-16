package org.irilo.appmockito.ejemplos.services;

import org.irilo.appmockito.ejemplos.models.Examen;
import org.irilo.appmockito.ejemplos.repositories.ExamenRepositorio;
import org.irilo.appmockito.ejemplos.repositories.PreguntaRepositorio;

import java.util.List;
import java.util.Optional;

public class ExamenServiceImp implements ExamenService {

    private ExamenRepositorio examenRepositorio;
    private PreguntaRepositorio preguntaRepositorio;

    public ExamenServiceImp(ExamenRepositorio examenRepositorio, PreguntaRepositorio preguntaRepositorio) {
        this.examenRepositorio = examenRepositorio;
        this.preguntaRepositorio = preguntaRepositorio;
    }

    @Override
    public Optional<Examen> findExamenPorNombre(String nombre) {

        return examenRepositorio.findAll().
                stream().
                filter(e -> e.getNombre().equals(nombre)).
                findFirst();
    }

    @Override
    public Examen findExamenPorNombreConPreguntas(String nombre) {
        Optional<Examen> examenOptional = findExamenPorNombre(nombre);
        Examen examen = null;
        if (examenOptional.isPresent()) {
            examen = examenOptional.orElseThrow();
            List<String> preguntas = preguntaRepositorio.findPreguntasPorExamenId(examen.getId());
            examen.setPreguntas(preguntas);
        }
        return examen;
    }

    @Override
    public Examen guardar(Examen examen) {

        if (!examen.getPreguntas().isEmpty()) {
            preguntaRepositorio.guardarVarias(examen.getPreguntas());
        }
        return examenRepositorio.guardar(examen);
    }
}

