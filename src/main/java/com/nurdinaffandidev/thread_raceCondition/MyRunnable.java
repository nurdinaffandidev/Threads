package com.nurdinaffandidev.thread_raceCondition;

public class MyRunnable implements Runnable {

    // Attributes
    Counter counter;
    int total = 0;
    int math = 0;

    // Constructor
    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    // Methods
    @Override
    public void run() {
        count();
    }

    private void count() {
        for (int i = 0; i < 10; i++) {
            counter.increment();
            total = total + counter.getCount();
            math = total * counter.getCount();

            String message = "[" + Thread.currentThread().getName() + "] "
                    + "[Time] " + System.currentTimeMillis()
                    + " [Count] "+ counter.getCount()
                    + " [Total] " + this.total
                    + " [Math] " + this.math;
//            System.out.println(message); // uncomment to see prints

            // Sleeping for 20ms to highlight race condition
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

