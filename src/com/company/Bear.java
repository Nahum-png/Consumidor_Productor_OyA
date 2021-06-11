package com.company;

public class Bear extends Thread{

    private Honeycomb honeycombConsumer; ///BUffer que compartira con las abejas
    private final int bear = 1; ///UNico oso en el programa

    /*Constructor de la clase*/
    public Bear(Honeycomb honeycomb){
        honeycombConsumer = honeycomb;
    }

    /*Metodos de la clase*/
    public void run(){
        int honeyToEat = 0;

        do {
            System.out.println("El oso esta buscando la miel.....");
            honeyToEat = honeycombConsumer.eatHoney();///come la miel
            System.out.println("El oso#" + bear + "comio del panal #" + honeyToEat + " de miel");///indica el oso y cuanta porcion comio
        } while (true);///infinito
    }
}
