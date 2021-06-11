package com.company;

public class Main {

    public static void main(String[] args) {
        int honey = (int)Math.random()*50+100; ///Cantidad de miel aleatoria
        int bees = (int)Math.random()*10+50; ///Entre 10 a 50 abejas aleatorias;
        Honeycomb honeycomb = new Honeycomb(honey);       ///Panal que sirve de buffer que compartiran el productor y consumidor
        Producer producer = new Producer(honeycomb, bees);
        Consumer consumer = new Consumer(honeycomb);

        consumer.start();
        producer.start();
    }
}
