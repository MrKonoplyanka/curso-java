package org.irilo.ejemplos.map;

import java.util.*;

public class EjemploHashMap {
    public static void main(String[] args) {
        Map<String,String> persona = new HashMap<>();
        persona.put(null,"1234");
        persona.put("nombre","John");
        persona.put("apellido","Doe");
        persona.put("apellido","Roe");
        persona.put("email","john.doe@gmail.com");
        persona.put("edad","38");

        System.out.println("persona = " + persona);

        String nombre = persona.get("nombre");
        System.out.println("nombre = " + nombre);

        persona.remove("apellido");

        Collection<String> valores = persona.values();
        for(String v: valores){
            System.out.println(v);
        }
        Set<String> llaves = persona.keySet();
        for (String k:llaves){
            System.out.println("k = " + k);
        }

        for(Map.Entry<String,String> par: persona.entrySet()){
            System.out.println(par.getKey()+" => " + par.getValue());
        }
        
        for(String llave: persona.keySet()){
            String valor = persona.get(llave);
            System.out.println(llave + " => " + valor);
        }

        persona.forEach((llave,valor) ->{
            System.out.println(llave + " => "+valor);
        });

    }

}
