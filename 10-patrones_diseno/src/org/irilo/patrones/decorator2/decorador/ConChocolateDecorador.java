package org.irilo.patrones.decorator2.decorador;

import org.irilo.patrones.decorator2.Configurable;

public class ConChocolateDecorador extends CafeDecorador{


    public ConChocolateDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() +5;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes().concat(", Chocolate");
    }
}
