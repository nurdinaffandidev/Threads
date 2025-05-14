package com.nurdinaffandidev.thread_raceCondition;

import java.util.ArrayList;
import java.util.List;

public class MainDemo {
    public static void main(String[] args) throws InterruptedException {
        int numberOfThreads = 10; /* Note: with 10, number of times counter incremented should be 10 * 10 = 100 */
        System.out.println("\nEXPECTED number of times counter incremented = " + numberOfThreads * 10);

        MyRunnable myRunnable = new MyRunnable(new Counter());
        List<Thread> allThreads = new ArrayList<Thread>();

        for (int i = 1; i <= numberOfThreads; i++) {
            allThreads.add(new Thread(myRunnable, "Thread" + i));
        }
        System.out.println("\nWithout synchronized method count: (race condition encountered)");
        System.out.println("==================================");
        for (Thread thread: allThreads) {
            thread.start();
        }

        for (Thread thread: allThreads) {
            thread.join();
        }

        System.out.println("Number of times counter was incremented: " + myRunnable.counter.getCount());
        System.out.println("Sum of all counters: " + myRunnable.total);
        System.out.println("Math result: " + myRunnable.math);

        allThreads.clear();
        MyRunnableSynchronized myRunnableSynchronized = new MyRunnableSynchronized(new Counter());

        for (int i = 1; i <= numberOfThreads; i++) {
            allThreads.add(new Thread(myRunnableSynchronized, "Thread" + i));
        }

        System.out.println("\nWith synchronized method count:");
        System.out.println("==================================");
        for (Thread thread: allThreads) {
            thread.start();
        }

        for (Thread thread: allThreads) {
            thread.join();
        }

        System.out.println("Number of times counter was incremented: " + myRunnableSynchronized.counter.getCount());
        System.out.println("Sum of all counters: " + myRunnableSynchronized.total);
        System.out.println("Math result: " + myRunnableSynchronized.math);
    }
}
