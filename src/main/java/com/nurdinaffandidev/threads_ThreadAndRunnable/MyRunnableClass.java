package com.nurdinaffandidev.threads_ThreadAndRunnable;

public class MyRunnableClass implements Runnable {

    // Attributes
    private MyClass myClass;

    // Constructor
    public MyRunnableClass(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("---------------------------------------------\n(MyRunnableClass) current 'number' value = " + myClass.getNumber());
            myClass.setNumber(myClass.getNumber() + 1);
            System.out.println("(MyRunnableClass) updated 'number' value = " + myClass.getNumber() + "\n---------------------------------------------");
        }
    }
}
