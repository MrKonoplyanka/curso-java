package org.irilo.java8.lamba;

import org.irilo.java8.lamba.models.Usuario;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {
        Predicate<Integer> test = num -> num > 10;
        boolean r = test.test(7);
        Predicate<String> t2 = role -> role.equals("ROLE_ADMIN");
        System.out.println(t2.test("ROLE_ADMIN"));

        BiPredicate<String,String> t3 = String::equals;//(a,b) -> a.equals(b);
        System.out.println("t3.test(\"andres\",\"pepe\") = " + t3.test("andres","pepe"));
        BiPredicate<Integer,Integer> t4 = (i,j) -> j > 1;
        boolean r2 = t4.test(5,10);
        System.out.println("r2 = " + r2);

        Usuario a = new Usuario();
        Usuario b = new Usuario();
        a.setNombre("maria");
        b.setNombre("maria");
        BiPredicate<Usuario,Usuario> t5 = (ua,ub)->ua.getNombre().equals(ub.getNombre());
        System.out.println(t5.test(a,b));

    }
}
