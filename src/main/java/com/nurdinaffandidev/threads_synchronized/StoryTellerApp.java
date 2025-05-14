package com.nurdinaffandidev.threads_synchronized;

public class StoryTellerApp {
    public static void main(String[] args) {
        House house = new House(1);
        /*
        - same instance of house is used in pigs and wolf class
        - synchronized keyword ensures house object is accessed synchronously between wolf and pigs class
         */
        Pigs pigs = new Pigs(house);
        Wolf wolf = new Wolf(house);

        Thread pigThread = new Thread(pigs);
        Thread wolfThread = new Thread(wolf);

        pigThread.start();
        wolfThread.start();
    }
}
