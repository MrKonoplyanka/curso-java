package org.irilo.patrones.factory.producto;

import org.irilo.patrones.factory.PizzaProducto;

public class PizzaCaliforniaQueso extends PizzaProducto {

    public PizzaCaliforniaQueso() {
        super();
        nombre = "Pizza California Queso";
        masa = "Masa a la piedra delgada";
        salsa = "Salsa de tomate rúcula";
        ingredientes.add("Extra Queso Mozzarella");
        ingredientes.add("Cebolla");
        ingredientes.add("Queso azul");

    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 35 min. a 100ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños triángulos");
    }
}
