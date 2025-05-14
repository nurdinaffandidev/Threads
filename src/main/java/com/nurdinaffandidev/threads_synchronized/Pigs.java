package com.nurdinaffandidev.threads_synchronized;

public class Pigs implements Runnable {

    // Attributes
    House house;

    // Constructor
    public Pigs(House house) {
        this.house = house;
    }

    // Methods
    @Override
    public void run() {
        storyBegins();
    }

    public void storyBegins() {
        /* NOTE: house will be the same instance in both pigs and wolf class */
        synchronized (house) { // use synchronized keyword for synchronized access to house object
            System.out.println("---------- START OF STORY! ----------\n");
            for(int i = 1; i <= 3; i++) {
                System.out.println("Pig " + house.getHouseNumber() + " is building house." );
                house.build(); indicateWait();

                try {
                    house.wait(); // causes the current thread to wait until it is awakened, typically by being notified or interrupted.
                    System.out.println("Pig " + house.getHouseNumber() + " is living in house " + house.getHouseNumber());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                if (house.getHouseNumber() == 3) {
                    house.remainStanding();
                    System.out.print("Pigs are snug and safe in house " + house.getHouseNumber() + ".");
                } else {
                    house.fallen();
                    System.out.print("Pig at house " + house.getHouseNumber() + " runs for life.");
                }

                indicateNotifyThenWait();
                house.notify();

                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }

                house.incrementHouseNumber();
                if (house.getHouseNumber() < 4) {
                    System.out.print("Moving on to next house number " + house.getHouseNumber() + ".");
                }
                house.notify(); indicateNotify();
                System.out.println();
            }
        }
    }

    private void indicateWait() {
        System.out.println(" ---> [pigThread] wait() called");
    }

    private void indicateNotify() {
        System.out.println(" ---> [pigThread] notify() called");
    }

    private void indicateNotifyThenWait() {
        System.out.println(" ---> [pigThread] notify() then wait() called");
    }
}
