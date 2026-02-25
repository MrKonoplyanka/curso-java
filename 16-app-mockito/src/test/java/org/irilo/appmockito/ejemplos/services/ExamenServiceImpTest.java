package org.irilo.appmockito.ejemplos.services;

import org.irilo.appmockito.ejemplos.models.Examen;
import org.irilo.appmockito.ejemplos.repositories.ExamenRepositorio;
import org.irilo.appmockito.ejemplos.repositories.PreguntaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExamenServiceImpTest {

    @Mock
    ExamenRepositorio examenRepositorio;
    @Mock
    PreguntaRepositorio preguntaRepositorio;

    @InjectMocks
    ExamenServiceImp service;

    @BeforeEach
    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        examenRepositorio = mock(ExamenRepositorio.class);
//        preguntaRepositorio = mock(PreguntaRepositorio.class);
//        service = new ExamenServiceImp(examenRepositorio,preguntaRepositorio);
    }

    @Test
    void findExamenPorNombre() {


        when(examenRepositorio.findAll()).thenReturn(Datos.EXAMENES);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");
        assertTrue(examen.isPresent());
        assertEquals(5L, examen.orElseThrow().getId());
        assertEquals("Matemáticas", examen.orElseThrow().getNombre());
    }

    @Test
    void findExamenPorNombreListaVacia() {
        List<Examen> datos = Collections.emptyList();
        when(examenRepositorio.findAll()).thenReturn(datos);
        Optional<Examen> examen = service.findExamenPorNombre("Matemáticas");
        assertFalse(examen.isPresent());
    }

    @Test
    void testPreguntasExamen() {
        when(examenRepositorio.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepositorio.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5,examen.getPreguntas().size());
    }

    @Test
    void testPreguntasExamenVerify() {
        when(examenRepositorio.findAll()).thenReturn(Datos.EXAMENES);
        when(preguntaRepositorio.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        assertEquals(5,examen.getPreguntas().size());
        verify(examenRepositorio).findAll();
        verify(preguntaRepositorio).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void testNoExisteExamenVerify() {
        when(examenRepositorio.findAll()).thenReturn(Collections.emptyList());
        when(preguntaRepositorio.findPreguntasPorExamenId(anyLong())).thenReturn(Datos.PREGUNTAS);
        Examen examen = service.findExamenPorNombreConPreguntas("Matemáticas");
        assertNull(examen);
        verify(examenRepositorio).findAll();
        verify(preguntaRepositorio).findPreguntasPorExamenId(anyLong());
    }

    @Test
    void testGuardarExamen() {
        Examen newExamen = Datos.EXAMEN;
        newExamen.setPreguntas(Datos.PREGUNTAS);
        when(examenRepositorio.guardar(any(Examen.class))).then(new Answer<Examen>() {
            Long secuencia = 8L;

            @Override
            public Examen answer(InvocationOnMock invocation) throws Throwable {
                Examen examen = invocation.getArgument(0);
                examen.setId(secuencia++);
                return examen;
            }
        });
        Examen examen = service.guardar(newExamen);
        assertNotNull(examen.getId());
        assertEquals(8L,examen.getId());
        assertEquals("Física",examen.getNombre());
        verify(examenRepositorio).guardar(any(Examen.class));
        verify(preguntaRepositorio).guardarVarias(anyList());
    }
}