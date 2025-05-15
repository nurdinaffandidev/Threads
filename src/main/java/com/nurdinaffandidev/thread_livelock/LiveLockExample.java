package com.nurdinaffandidev.thread_livelock;

/*
Notice that both keep passing the spoon out of politeness resulting in — livelock.
 */
public class LiveLockExample {
    public static void main(String[] args) {

        Diner diner1 = new Diner("diner1");
        Diner diner2 = new Diner("diner2");

        Spoon spoon = new Spoon(diner1);

        new Thread(() -> diner1.eatWith(spoon, diner2)).start();
        new Thread(() -> diner2.eatWith(spoon, diner1)).start();
    }
}
