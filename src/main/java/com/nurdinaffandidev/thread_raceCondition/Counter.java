package com.nurdinaffandidev.thread_raceCondition;

public class Counter {

    private int count;

    public Counter() {
        count = 0;
    }

    public void setCount(int i) {
        count = i;
    }

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}
