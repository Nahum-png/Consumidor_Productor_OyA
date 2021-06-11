package com.company;

public class Bee extends Thread {

    private Honeycomb honeycomb; /// Buffer que se compartira con los osos
    private int beeIdentifier; ///Identificador de abeja
    private int honeyContribution; ///Cuanta miel debe aportar cada abeja


    /*Constructor de la clase*/
    public Bee(Honeycomb honeycomb, int identifier, int contributiones) {
        this.honeycomb = honeycomb;
        beeIdentifier = identifier;
        honeyContribution = contributiones;

    }

    /*Metodos de la clase*/
    public void run() { ///Metodo donde trabajan las abejas
        do {
            honeycomb.putHoney(honeyContribution); ///guardan miel
            System.out.println("La abeja numero #" + beeIdentifier + " coloco en el panal :" + honeyContribution);///imprime las acciones de las abejas junto con su identificador y cantidad de miel
            try {
                sleep((int) Math.random() * 150);///duerme a las abejas
            } catch (InterruptedException e) {
            }
        } while (true);///infinito
    }


}
