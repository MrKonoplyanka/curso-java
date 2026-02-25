package org.irilo.patrones.composite.ejemplo;

import org.irilo.patrones.composite.Archivo;
import org.irilo.patrones.composite.Directorio;

public class EjemploCompositeBuscar {
    public static void main(String[] args) {

        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));

        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("cv.docx"));
        doc.addComponente(new Archivo("lobo.jpeg"));

        boolean encontrado = doc.buscar("patron-composite.docx");
        System.out.println("Encontrado \" patron-composite.docx\": " + encontrado);


        encontrado = doc.buscar("Api StreamError");
        System.out.println("Encontrado \"Api Stream\": " + encontrado);
    }
}
