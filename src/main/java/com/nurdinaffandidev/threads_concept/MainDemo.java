package com.nurdinaffandidev.threads_concept;

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
    public static void main(String[] args) {
        new BasicThread("London").start();
        new BasicThread("New York").start();
        new BasicThread("Tokyo").start();
        new BasicThread("Singapore").start();
        new BasicThread("Hong Kong").start();

        for (int i = 1; i < 10; i++) {
            System.out.println(i + " main() code");
        }
        System.out.println("DONE! main()");
    }
}
