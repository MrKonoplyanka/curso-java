package org.irilo.patrones.factory;

public class EjemploFactory {

    public static void main(String[] args) {
        PizzeriaZonaAbstractFactory ny = new PizzeriaNewYorkFactory();
        PizzeriaZonaAbstractFactory california = new PizzeriaCaliforniaFactory();

        PizzaProducto pizza = california.ordenarPizza("queso");
        System.out.println("Bruce ordena la pizza " + pizza.getNombre());

        pizza = ny.ordenarPizza("pepperoni");
        System.out.println("Andrés ordena una " + pizza.getNombre());

        pizza = california.ordenarPizza("vegetariana");
        System.out.println("James ordena " + pizza.getNombre());




    }
   }
