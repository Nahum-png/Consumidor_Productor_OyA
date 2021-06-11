package com.company;

public class Honeycomb {

    private int amountHoney; ///capacidad que acepta el panal
    private int honeyComb; ///contador de panal que va guardando la miel de las abejas
    private boolean readyToEat = false; ///booleano que indica si esta listo el panal para comer

    public Honeycomb(int honey){
        amountHoney = honey;
    } ///constructor de la clase

    public void putHoney(int honey){ ///metodo para las abejas para guardar la miel
        while(readyToEat == true){  ///verifica que este true cuando hayan terminado de guardar toda la miel
            try{
                synchronized (this) {  ///sincroniza a los hilos junto con el objeto panal
                    wait(); ///duerme a las abejas
                }
            }catch (InterruptedException e){
            }
        }
        honeyComb = honeyComb + honey;///contador de miel que se guarda
        if(honeyComb == amountHoney){
            readyToEat = true; ///cambia cuando ya terminaron de guardar la miel
            synchronized (this){///sincroniza a los hilos junto con el objeto panal
                notifyAll(); ///despierta al oso
            }
        }
    }

    public int eatHoney(){  ///metodo para el oso que se coma la miel
        while(readyToEat == false){ /// verifica para ver si el oso termino de comer
            try{
                synchronized (this){///sincroniza a los hilos junto con el objeto panal
                    wait();///duerme al oso
                }
            }catch (InterruptedException e){
            }
        }
        honeyComb = 0;  ///Comio el oso todas las porciones
        readyToEat = false; ///pasa a falso cuando termino de comer el oso
        synchronized (this){///sincroniza a los hilos junto con el objeto panal
            notifyAll();///despierta a las abejas
        }
        return amountHoney; ///regresa la cantidad de miel que comio el oso
    }

    /*Getters & Setters*/
    public int getAmountHoney() {
        return amountHoney;
    }

    public void setAmountHoney(int amountHoney) {
        this.amountHoney = amountHoney;
    }

    public int getHoneyComb() {
        return honeyComb;
    }

    public void setHoneyComb(int honeyComb) {
        this.honeyComb = honeyComb;
    }
}
