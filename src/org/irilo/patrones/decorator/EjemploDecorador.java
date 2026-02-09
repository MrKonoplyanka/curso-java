package org.irilo.patrones.decorator;

import org.irilo.patrones.decorator.decorador.MayusculaDecorador;
import org.irilo.patrones.decorator.decorador.ReversaDecorador;
import org.irilo.patrones.decorator.decorador.SubrayadoDecorador;

import java.text.Normalizer;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Andrés!");
        MayusculaDecorador may = new MayusculaDecorador(texto);
        ReversaDecorador rev = new ReversaDecorador(may);
        SubrayadoDecorador sub
    }
}
