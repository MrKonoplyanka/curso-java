package org.irilo.patrones.decorator.decorador;

import org.irilo.patrones.decorator.Formateable;

public class ReemplazarEspacio extends TextoDecorador{
    public ReemplazarEspacio(Formateable texto) {
        super(texto);
    }

    @Override
    public String darFormato() {

        return texto.darFormato().replace(" ","_");
    }
}
