package org.irilo.patrones.decorator2.decorador;

import org.irilo.patrones.decorator2.Configurable;

public class ConCremaDecorador extends CafeDecorador{
    public ConCremaDecorador(Configurable cafe) {
        super(cafe);
    }

    @Override
    public float getPrecioBase() {
        return cafe.getPrecioBase() +2.5f;
    }

    @Override
    public String getIngredientes() {
        return cafe.getIngredientes().concat(", Crema");
    }
}
