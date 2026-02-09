package org.irilo.patrones.factory.producto;

import org.irilo.patrones.factory.PizzaProducto;

public class PizzaCaliforniaVegetariana extends PizzaProducto {

    public PizzaCaliforniaVegetariana() {
        super();
        nombre = "Pizza California vegetariana";
        masa = "Delgada light";
        salsa = "Salsa BBQ light";
        ingredientes.add("Queso Mozzarella");
        ingredientes.add("Aceitunas");
        ingredientes.add("Espinacas");
        ingredientes.add("Berenjena");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 20 min. a 180ºC");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas rectangulares");
    }
}
