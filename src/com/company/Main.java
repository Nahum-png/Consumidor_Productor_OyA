package com.company;

public class Main {

    public static void main(String[] args) {

        int honey = (int)Math.random()*50+100; ///Cantidad de miel aleatoria
        int bees = (int)Math.random()*10+50; ///Entre 10 a 50 abejas aleatorias;

        Honeycomb honeycomb = new Honeycomb(honey);///Panal que sirve de buffer que compartiran el productor y consumidor
        Bee[] workerBees = new Bee[bees];///arreglo de abejas
        Bear bear = new Bear(honeycomb);///UNico oso del programa

        for(int i=1; i< bees; i++){ ///Inicializa a las abejas con su id y cantidad de miel que guardaran
            workerBees[i] = new Bee(honeycomb, i, (honeycomb.getAmountHoney())/bees);
            workerBees[i].start(); ///se inicia el hilo de cada abeja
        }

        bear.start();///se inicia el hilo del oso
    }
}
