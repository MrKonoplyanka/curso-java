package org.irilo.patrones.decorator;

import org.irilo.patrones.decorator.decorador.MayusculaDecorador;
import org.irilo.patrones.decorator.decorador.ReversaDecorador;
import org.irilo.patrones.decorator.decorador.SubrayadoDecorador;

import java.text.Normalizer;

public class EjemploDecorador {
    public static void main(String[] args) {
        Formateable texto = new Texto("Hola que tal Andrés!");
        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayado = new SubrayadoDecorador(reversa);

        System.out.println(subrayado.darFormato());
    }
}
