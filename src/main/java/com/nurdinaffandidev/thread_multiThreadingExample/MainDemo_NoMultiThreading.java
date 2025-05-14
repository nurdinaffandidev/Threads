package com.nurdinaffandidev.thread_multiThreadingExample;

/*
This takes roughly 2 seconds (100ms * 10 * 2).
 */
public class MainDemo_NoMultiThreading {
    public static void main(String[] args) {
        // Task 1: Print numbers
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            if (i == 10) {
                System.out.println("DONE! - NumberPrinter");
            }
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        // Task 2: Print characters
        for (char c = 'A'; c <= 'J'; c++) {
            System.out.println("Character: " + c);
            if (c == 'J') {
                System.out.println("DONE! - CharacterPrinter");
            }
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
}
