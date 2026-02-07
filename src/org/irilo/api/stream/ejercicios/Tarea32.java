package org.irilo.api.stream.ejercicios;

import java.util.ArrayList;
import java.util.List;

public class Tarea32 {

    public static void main(String[] args) {

        List<Producto> lista = new ArrayList<>();
        lista.add(new Producto(3.5,5));
        lista.add(new Producto(27.6,3));
        lista.add(new Producto(0.80,12));
        lista.add(new Producto(74.1,1));
        lista.add(new Producto(4.2,23));

        double resultado = lista.stream()
                .map((p)->{
                    double coste = (double)p.getCantidad() * p.getPrecio();
                    return coste;
                })
                .reduce(0.0, (a,b)-> a+b);
        System.out.println("resultado = " + resultado);

        



    }

    public static class Producto{

        private double precio;
        private int cantidad;

        public Producto(double precio, int cantidad) {
            this.precio = precio;
            this.cantidad = cantidad;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
    }
}


