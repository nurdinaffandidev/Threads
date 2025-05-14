package com.nurdinaffandidev.threads_ThreadAndRunnable;

public class MyThreadClass extends Thread {
    // Attributes
    private MyClass myClass;

    // Constructor
    public MyThreadClass(MyClass myClass) {
        this.myClass = myClass;
    }

    // Methods
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("=============================================\n(MyThreadClass) current 'number' value = " + myClass.getNumber());
            myClass.setNumber(myClass.getNumber() + 1);
            System.out.println("(MyThreadClass) updated 'number' value = " + myClass.getNumber() + "\n=============================================");
        }
    }
}
