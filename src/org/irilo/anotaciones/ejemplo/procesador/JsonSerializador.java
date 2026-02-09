package org.irilo.anotaciones.ejemplo.procesador;

import org.irilo.anotaciones.ejemplo.Init;
import org.irilo.anotaciones.ejemplo.JsonAtributo;
import org.irilo.anotaciones.ejemplo.procesador.exception.JsonSerializadorException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonSerializador {


    public static void inicializarObjeto(Object obj){

        if(Objects.isNull(obj)){
            throw new JsonSerializadorException("el objeto no puede ser nulo");
        }
        Method[] metodos = obj.getClass().getDeclaredMethods();
        Arrays.stream(metodos).filter(m->m.isAnnotationPresent(Init.class))
                .forEach(m-> {
                    m.setAccessible(true);
                    try {
                        m.invoke(obj);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JsonSerializadorException("Error al serializar, no se puede inicializar el objeto");
                    }
                });

    }
    public static String convertirJson(Object obj){

        if(Objects.isNull(obj)){
            throw new JsonSerializadorException("el objeto no puede ser nulo");
        }
        inicializarObjeto(obj);
        Field[] atributos = obj.getClass().getDeclaredFields();
        return Arrays.stream(atributos)
                .filter(field -> field.isAnnotationPresent(JsonAtributo.class))
                .map(field -> {
                    field.setAccessible(true);
                    String nombre = field.getAnnotation(JsonAtributo.class).nombre().equals("")
                            ? field.getName()
                            : field.getAnnotation(JsonAtributo.class).nombre();
                    try {
                        Object valor = field.get(obj);

                        if (field.getAnnotation(JsonAtributo.class).capitalizar() && valor instanceof String){
                            String nuevoValor = (String) valor;
                            nuevoValor = Arrays.stream(nuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0,1).toUpperCase()
                                    + palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));
                                    field.set(obj,nuevoValor);
                        }
                        return "\"" + nombre + "\":\"" + field.get(obj) + "\"";
                    } catch (IllegalAccessException e) {
                        throw new JsonSerializadorException("Error al serializar a Json: "+e.getMessage());
                    }
                })
                .reduce("{", (a,b) ->{
                    if ("{".equals(a)){
                        return a+b;
                    }
                    else {
                        return a + "," + b;
                    }
                }).concat("}");
    }
}
