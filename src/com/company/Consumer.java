package com.company;

public class Consumer extends Thread{

    Honeycomb honeycombConsumer; ///BUffer que compartira con las abejas
    private final int bear = 1; ///UNico oso en el programa
    /*Constructor de la clase*/
    public Consumer(Honeycomb honeycomb){
        honeycombConsumer = honeycomb;
    }

    /*Metodos de la clase*/
    public void executeConsumer(){
        int honeyToEat = 0;
        for( ; ; ){
            honeyToEat = honeycombConsumer.eatHoney();
            System.out.println("El oso#" + bear + "comio del panal #" + honeyToEat + " de miel");
        }
    }
}
