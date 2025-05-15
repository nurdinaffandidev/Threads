package com.nurdinaffandidev.thread_deadlock;

/*
Notice when running that Thread1 never got hold of lock2 and Thread2 never got hold of lock1
as both are waiting for the other to release the lock each is holding on resulting in a deadlock.
 */
public class DeadLockExample {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread1: Holding lock1...");
                try {
                    Thread.sleep(100); //simulate working process in thread
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("Thread1: Acquired lock2 too!");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread2: Holding lock2...");
                try {
                    Thread.sleep(100); //simulate working process in thread
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("Thread2: Acquired lock1 too!");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
