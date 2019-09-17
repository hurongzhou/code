package com.code;

public class ThreadB implements Runnable {

    private Animal animal;

    public ThreadB(Animal animal){
        super();
        this.animal=animal;
    }

    public void run() {
        animal.name("aa");
    }
}
