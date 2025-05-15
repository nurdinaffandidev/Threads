package com.nurdinaffandidev.thread_livelock;

public class Spoon {
    // Attributes
    private Diner diner;

    // Constructor
    public Spoon(Diner diner) {
        this.diner = diner;
    }

    // Getter Setter
    public Diner getDiner() {
        return diner;
    }

    public void setDiner(Diner diner) {
        this.diner = diner;
    }

    // Methods
    public synchronized  void use() {
        System.out.println(diner.getName() + " is eating..");
    }
}
