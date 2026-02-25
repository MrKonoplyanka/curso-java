package org.irilo.patrones.factory.producto;

import org.irilo.patrones.factory.PizzaProducto;

public class PizzaCaliforniaPepperoni extends PizzaProducto {

    public PizzaCaliforniaPepperoni() {
        super();
        nombre = "Pizza California Pepperoni";
        masa = "Masa a la piedra gruesa";
        salsa = "Salsa BBQ light";
        ingredientes.add("Extra Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("pepperoni");

    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 50 min. a 55ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en pequeños rectangulos");
    }
}
