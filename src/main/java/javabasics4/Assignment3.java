package javabasics4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Write a program with one thread (the producer) that produces items (in this case, simple ints).
 * Another thread (the consumer) consumes items. For communication purposes, both threads have
 * access to a bounded buffer which is basically an array.
 */
public class Assignment3 {

    private static final int BUFFER_CAPACITY = 2;
    private static final int MAX_PRODUCE = 10;
    private static final int RANDOM_SLEEP_SECS = 10;

    public static void main(String... args) {
        IntBuffer buffer = new IntBuffer(BUFFER_CAPACITY);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Producer(buffer));
        executor.execute(new Consumer(buffer));
        executor.shutdown();
    }

    private static class Producer implements Runnable {

        private final IntBuffer buffer;

        private Producer(IntBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                int value = 1;
                while (value <= MAX_PRODUCE) {
                    buffer.write(value++);
                    TimeUnit.SECONDS.sleep(random.nextInt(RANDOM_SLEEP_SECS) + 1);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class Consumer implements Runnable {

        private final IntBuffer buffer;

        private Consumer(IntBuffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            Random random = new Random();
            try {
                int reads = 0;
                while (reads < MAX_PRODUCE) {
                    buffer.read();
                    reads++;
                    TimeUnit.SECONDS.sleep(random.nextInt(RANDOM_SLEEP_SECS) + 1);
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static class IntBuffer {
        private final LinkedList<Integer> queue = new LinkedList<>();
        private final Lock lock = new ReentrantLock();
        private final Condition notEmpty = lock.newCondition();
        private final Condition notFull = lock.newCondition();
        private final int capacity;

        private IntBuffer(int capacity) {
            this.capacity = capacity;
            System.out.println("Buffer capacity: " + capacity);
            System.out.println("Operation\tBuffer after op");
        }

        public int read() {
            lock.lock();
            int value = 0;
            try {
                while (queue.isEmpty()) {
                    System.out.println("Can't read. Waiting for notEmpty condition");
                    notEmpty.await();
                }
                value = queue.remove();
                System.out.println("Read " + value + "\t\t" + Arrays.toString(queue.toArray()));
                notFull.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
            return value;
        }

        public void write(int value) {
            lock.lock();
            try {
                while (queue.size() == capacity) {
                    System.out.println("Can't write. Waiting for notFull condition");
                    notFull.await();
                }
                queue.offer(value);
                System.out.println("Writ " + value + "\t\t" + Arrays.toString(queue.toArray()));
                notEmpty.signal();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
