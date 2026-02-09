package org.irilo.archivos.ejemplos;

import org.irilo.archivos.ejemplos.servicio.ArchivoServicio;

public class EjemploCrearArchivo {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\ivanr\\OneDrive\\Documentos\\CURSOS 2025\\Curso Java\\archivo\\java.txt";

        ArchivoServicio service = new ArchivoServicio();
        service.crearArchivo2(nombreArchivo);
    }
}
