package org.ThreadControlandDeadlocks;

class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    // Method that can cause deadlock
    public void methodOne() {
        synchronized (lock1) {
            System.out.println("Thread 1 acquired lock1");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (lock2) {
                System.out.println("Thread 1 acquired lock2");
            }
        }
    }

    public void methodTwo() {
        synchronized (lock2) {
            System.out.println("Thread 2 acquired lock2");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (lock1) {
                System.out.println("Thread 2 acquired lock1");
            }
        }
    }
}

public class SynchronisationDeadlock {
    public static void runDeadlockExample() {
        DeadlockExample deadlock = new DeadlockExample();

        Thread t1 = new Thread(deadlock::methodOne);
        Thread t2 = new Thread(deadlock::methodTwo);

        t1.start();
        t2.start();
    }
}
