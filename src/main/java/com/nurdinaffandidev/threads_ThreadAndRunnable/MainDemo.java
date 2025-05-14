package com.nurdinaffandidev.threads_ThreadAndRunnable;

/*
•	In Java, every application has at least one thread – the main thread:
•	Its set of instructions are the code in the main() method
•	Starts running when main() is invoked
•	We can create other threads (ie. another main())
•	These will run concurrently with the main thread
•	Background system threads also compete with our threads for CPU time
•	The JVM’s thread scheduler decides which one runs when
 */
public class MainDemo {
    public static void main( String[] args ) {
        MyClass myClassThread = new MyClass(0);
        MyClass myClassRunnable = new MyClass(0);

        Thread thread1 = new MyThreadClass(myClassThread); // inherits Thread
        Thread thread2 = new Thread(new MyRunnableClass(myClassRunnable)); // implements Runnable

        thread1.start();
        thread2.start();
    }
}
