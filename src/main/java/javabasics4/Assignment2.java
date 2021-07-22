package javabasics4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Write a program to create a deadlock between two threads.
 */
public class Assignment2 {

    public static void main(String... args) {
        final Object object1 = new Object();
        final Object object2 = new Object();

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new TaskOne(object1, object2));
        executor.execute(new TaskTwo(object1, object2));
    }

    private static class TaskOne implements Runnable {

        private final Object object1;
        private final Object object2;

        private TaskOne(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object1) {
                try {
                    Thread.sleep(100);
                    System.out.println("Using object1 with TaskOne");
                } catch (InterruptedException ex) {}
                synchronized (object2) {
                    System.out.println("Using object2 with TaskOne");
                }
            }
        }
    }

    private static class TaskTwo implements Runnable {

        private final Object object1;
        private final Object object2;

        private TaskTwo(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            synchronized (object2) {
                try {
                    Thread.sleep(100);
                    System.out.println("Using object2 with TaskTwo");
                } catch (InterruptedException ex) {}
                synchronized (object1) {
                    System.out.println("Using object1 with TaskTwo");
                }
            }
        }
    }
}


