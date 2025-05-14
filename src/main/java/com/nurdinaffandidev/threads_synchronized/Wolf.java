package com.nurdinaffandidev.threads_synchronized;

public class Wolf implements Runnable {

    // Attributes
    private House house;

    // Constructor
    public Wolf(House house) {
        this.house = house;
    }

    // Methods
    @Override
    public void run() {
        startChasing();
    }

    private void startChasing() {
        /* NOTE: house will be the same instance in both pigs and wolf class */
        synchronized (house) { // use synchronized keyword for synchronized access to house object
            for (int i = 1; i <= 3; i++) {
                System.out.println("Wolf is looking for pigs.");
                System.out.println("Wolf sees pig in house " + house.getHouseNumber() + " and blows the house.");
                house.blown(); indicateNotifyThenWait();
                house.notify();

                try {
                    house.wait();
                    if (house.getHouseNumber() < 3) {
                        System.out.print("Wolf chase after pig from house " + house.getHouseNumber() + ".");
                    } else {
                        System.out.println("Wolf climbs chimney");
                        System.out.println("Wolf got stuck in the chimney...");
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                house.notify(); indicateNotifyThenWait();

                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            System.out.println("---------- END OF STORY! ----------");
        }
    }

    private void indicateWait() {
        System.out.println(" ---> [wolfThread] wait() called");
    }

    private void indicateNotify() {
        System.out.println(" ---> [wolfThread] notify() called");
    }

    private void indicateNotifyThenWait() {
        System.out.println(" ---> [wolfThread] notify() then wait() called");
    }
}
