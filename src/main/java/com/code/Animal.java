package com.code;

/**
 * @author hurong3
 * @date 2019-08-05 12:56
 */
public class Animal {

    public void shout(String s){
        synchronized (s){
            System.out.println("shout begin--"+System.currentTimeMillis());
            System.out.println("shout~~~");
            try {
                s.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("shout end--"+System.currentTimeMillis());
        }
    }

    public void name(String s){
        synchronized (s){
            System.out.println("name begin--"+System.currentTimeMillis());
            System.out.println("tiger");
            System.out.println("name end--"+System.currentTimeMillis());
            s.notify();
        }
    }
}
