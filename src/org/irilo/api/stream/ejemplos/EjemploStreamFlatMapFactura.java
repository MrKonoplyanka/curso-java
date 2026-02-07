package org.irilo.api.stream.ejemplos;

import org.irilo.api.stream.ejemplos.models.Factura;
import org.irilo.api.stream.ejemplos.models.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStreamFlatMapFactura {
    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("John","Doe");
        Usuario usuario2 = new Usuario("Pepe","Pérez");

        usuario1.addFactura(new Factura("Compras tecnológicas"));
        usuario1.addFactura(new Factura("Compra muebles"));
        usuario2.addFactura(new Factura("Bicicleta"));
        usuario2.addFactura(new Factura("Notebook gamer"));

        List<Usuario> usuarios = Arrays.asList(usuario1,usuario2);

//        for (Usuario u: usuarios){
//            for (Factura f: u.getFacturas()){
//                System.out.println(f.getDescripcion());
//            }
//        }

        usuarios.stream()
                .flatMap(u -> u.getFacturas().stream())
                .forEach( f -> System.out.println(f.getDescripcion().concat(": cliente ").concat(f.getUsuario().toString())));
    }
}
