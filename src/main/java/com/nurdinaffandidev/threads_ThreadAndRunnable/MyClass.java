package com.nurdinaffandidev.threads_ThreadAndRunnable;

public class MyClass {
    // Attributes
    private int number;

    // Constructor
    public MyClass(int number) {
        this.number = number;
    }

    // Getter Setter
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    // Methods
    @Override
    public String toString() {
        return "MyClass{" +
                "number=" + number +
                '}';
    }
}
