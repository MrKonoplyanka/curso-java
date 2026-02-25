package org.irilo.patrones.factory;

import org.irilo.patrones.factory.producto.PizzaCaliforniaPepperoni;
import org.irilo.patrones.factory.producto.PizzaCaliforniaQueso;
import org.irilo.patrones.factory.producto.PizzaCaliforniaVegetariana;

public class PizzeriaCaliforniaFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        return switch (tipo) {
            case "queso" -> new PizzaCaliforniaQueso();
            case "pepperoni" -> new PizzaCaliforniaPepperoni();
            case "vegetariana" -> new PizzaCaliforniaVegetariana();
            default -> null;
        };
    }
}
