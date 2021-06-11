package com.company;

public class Producer extends Thread{
    /* class Producer or Bees*/
    Honeycomb honeycombProducer; /// Buffer que se compartira con los osos

    public int beesNumber; ///Número de abejas
    public int beeIdentifier; ///Identificador de abeja
    public int honeyContribution; ///Cuanta miel debe aportar cada abeja
    private final Producer[] workerBees = new Producer[beesNumber];   ///checar el final de aqui

    /*Constructor de la clase*/
    public Producer(Honeycomb honeycomb, int bees){
        honeycombProducer = honeycomb;
        beesNumber = bees;
    }
    public Producer(){}


    /*Metodos de la clase*/
    public void executeProducer(){ ///Metodo donde trabajan las abejas
        initializeBees();
        do {
            int i;
            for (i = 1; i < beesNumber; i++) {
                honeycombProducer.putHoney(workerBees[i].honeyContribution);
                System.out.println("La abeja numero #" + workerBees[i].beeIdentifier + " coloco en el panal :" + workerBees[i].honeyContribution + "de miel");
                try {
                    sleep((int) Math.random() * 150);
                } catch (InterruptedException e) {
                }
            }
        } while (true);
    }

    public void initializeBees(){
        for(int i=1; i< beesNumber; i++){
            workerBees[i].beeIdentifier = i; ///se le asigna a cada abeja un identificador
            workerBees[i].honeyContribution = (honeycombProducer.getAmountHoney())/beesNumber; ///Cantidad que cada abeja debe aportar al panal
        }
    }
}
