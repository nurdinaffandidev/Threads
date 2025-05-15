package com.nurdinaffandidev.thread_deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockSolution_TryLockWithTimeout {
    static final ReentrantLock lock1 = new ReentrantLock();
    static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread1: Acquired lock1");
                    try {
                        Thread.sleep(50); // Simulate some work
                        System.out.println("Thread1: Working in lock1....");
                        if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread1: Acquired lock2 too");
                            } finally {
                                lock2.unlock();
                                System.out.println("Thread1: Released lock2");
                            }
                        } else {
                            System.out.println("Thread1: Could not acquire lock2");
                        }
                    } finally {
                        lock1.unlock();
                        System.out.println("Thread1: Released lock1");
                    }
                } else {
                    System.out.println("Thread1: Could not acquire lock1");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                if (lock2.tryLock(100, TimeUnit.MILLISECONDS)) {
                    System.out.println("Thread2: Acquired lock2");
                    try {
                        Thread.sleep(50); // Simulate some work
                        System.out.println("Thread2: Working in lock2....");
                        if (lock1.tryLock(100, TimeUnit.MILLISECONDS)) {
                            try {
                                System.out.println("Thread2: Acquired lock1 too");
                            } finally {
                                lock1.unlock();
                                System.out.println("Thread2: Released lock1");
                            }
                        } else {
                            System.out.println("Thread2: Could not acquire lock1");
                        }
                    } finally {
                        lock2.unlock();
                        System.out.println("Thread2: Released lock2");
                    }
                } else {
                    System.out.println("Thread2: Could not acquire lock2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }
}
