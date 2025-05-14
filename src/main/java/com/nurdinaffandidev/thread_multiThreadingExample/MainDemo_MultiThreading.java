package com.nurdinaffandidev.thread_multiThreadingExample;


class NumberPrinter extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            if (i == 10) {
                System.out.println("DONE! - NumberPrinter");
            }
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

class CharacterPrinter extends Thread {
    public void run() {
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println("Character: " + c);
            if (c == 'J') {
                System.out.println("DONE! - CharacterPrinter");
            }
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}

/*
In this version, both tasks run in parallel, so total time is about 1 second,
effectively halving the processing time.
*/
public class MainDemo_MultiThreading {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();
        CharacterPrinter cp = new CharacterPrinter();

        np.start(); // Start first thread
        cp.start(); // Start second thread
    }
}
