package org.irilo.appmockito.ejemplos.services;

import org.irilo.appmockito.ejemplos.models.Examen;

import java.util.Arrays;
import java.util.List;

public class Datos {
    public static final List<Examen> EXAMENES = Arrays.asList(
            new Examen(5L, "Matemáticas"),
            new Examen(6L, "Lenguaje"),
            new Examen(9L, "Historia"),
            new Examen(3L, "Francés"));
    public static final List<String> PREGUNTAS = Arrays.asList(
            "Aritmética",
            "Integrales",
            "Geometría",
            "Trigonometría",
            "Derivadas"
    );
    public static final Examen EXAMEN = new Examen(null,"Física");
}
