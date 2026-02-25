package org.irilo.patrones.factory;

import org.irilo.patrones.factory.producto.PizzaNewYorkItaliana;
import org.irilo.patrones.factory.producto.PizzaNewYorkPepperoni;
import org.irilo.patrones.factory.producto.PizzaNewYorkVegetariana;

public class PizzeriaNewYorkFactory extends PizzeriaZonaAbstractFactory{
    @Override
    PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = switch (tipo) {
            case "vegetariana" -> new PizzaNewYorkVegetariana();
            case "pepperoni" -> new PizzaNewYorkPepperoni();
            case "italiana" -> new PizzaNewYorkItaliana();
            default -> null;
        };
        return producto;
    }
}
