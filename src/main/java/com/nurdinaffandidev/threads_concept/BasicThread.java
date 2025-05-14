package com.nurdinaffandidev.threads_concept;

public class BasicThread extends Thread {
    // Constructor

    public BasicThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + " " + getName());

            try {
                sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("DONE! " + getName());
    }
}
