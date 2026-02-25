package org.irilo.patrones.singleton;

import java.util.Objects;

public class ConexionBDSingleton {
    private static ConexionBDSingleton instancia;

    private ConexionBDSingleton(){
        System.out.println("Conectándose algún nmotor de base de datos");
    }

    public static ConexionBDSingleton getInstancia(){
        if(instancia == null){
            instancia = new ConexionBDSingleton();
        }
        return instancia;
    }


}
