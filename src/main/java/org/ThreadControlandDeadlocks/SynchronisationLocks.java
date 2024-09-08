package org.ThreadControlandDeadlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

class LockExample {
    private int count = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    // Method to increment count with lock
    public void increment() {
        lock.lock();
        try {
            count++;
            condition.signalAll(); // Notify all waiting threads
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    // Method that simulates waiting for a condition
    public void waitForCondition() throws InterruptedException {
        lock.lock();
        try {
            condition.await(); // Wait until signaled
            System.out.println("Condition met, count: " + count);
        } finally {
            lock.unlock();
        }
    }
}

public class SynchronisationLocks {
    public static void runLocksExample() throws InterruptedException {
        LockExample lockExample = new LockExample();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                lockExample.increment();
            }
        });

        Thread waitThread = new Thread(() -> {
            try {
                lockExample.waitForCondition();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        incrementThread.start();
        waitThread.start();

        incrementThread.join();
        waitThread.join();

        System.out.println("Final count after lock operations: " + lockExample.getCount());
    }
}
