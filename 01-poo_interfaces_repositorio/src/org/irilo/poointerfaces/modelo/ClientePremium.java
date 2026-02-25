package org.irilo.poointerfaces.modelo;

public class ClientePremium extends Cliente implements Comparable{
    public ClientePremium(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
