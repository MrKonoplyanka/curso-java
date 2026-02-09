package org.irilo.patrones.decorator2;

import org.irilo.patrones.decorator2.decorador.CafeDecorador;
import org.irilo.patrones.decorator2.decorador.ConChocolateDecorador;
import org.irilo.patrones.decorator2.decorador.ConCremaDecorador;
import org.irilo.patrones.decorator2.decorador.ConLecheDecorador;

public class EjemploDecoradorCafe {
    public static void main(String[] args) {

        Configurable cafe = new Cafe(7, "Cafe Mocha");
        CafeDecorador conCrema = new ConCremaDecorador(cafe);
        CafeDecorador conLeche = new ConLecheDecorador(conCrema);
        CafeDecorador conChocolate = new ConChocolateDecorador(conLeche);

        System.out.println("El precio del cafe moca es: " + conChocolate.getPrecioBase());
        System.out.println("Los ingredientes: " + conChocolate.getIngredientes());

    }
}
