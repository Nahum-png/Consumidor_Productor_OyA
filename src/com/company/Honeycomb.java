package com.company;

public class Honeycomb {
    public int amountHoney; ///marcador de cantidad de miel en el panal
    private int honeyComb; /// arreglo donde se guardara la miel y de donde comera el oso
    private boolean readyToEat = false; ///booleano que indica si esta listo el panal para comer

    public Honeycomb(int honey){
        amountHoney = honey;
    }

    public void putHoney(int honey){ ///metodo para las abejas que pondran la miel
        while(readyToEat == true){
            try{
                wait();
            }catch (InterruptedException e){
            }
        }
        honeyComb = honeyComb + honey;
        if(honeyComb == amountHoney){
            readyToEat = true;
        }
    }

    public int eatHoney(){  ///metodo para el oso que se coma la miel
        while(readyToEat == false){
            try{
                wait();
            }catch (InterruptedException e){
            }
        }
        honeyComb = 0;  ///Comio el oso todas las porciones
        readyToEat = false;
        notifyAll();
        return amountHoney;
    }

    /*Getters & Setters*/
    public int getAmountHoney() {
        return amountHoney;
    }

    public void setAmountHoney(int amountHoney) {
        this.amountHoney = amountHoney;
    }
}
