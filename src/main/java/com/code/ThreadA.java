package com.code;

public class ThreadA implements Runnable{

    private Animal animal;

    public ThreadA(Animal animal){
        this.animal=animal;
    }

    public void run() {
        animal.shout("aa");
    }
}
