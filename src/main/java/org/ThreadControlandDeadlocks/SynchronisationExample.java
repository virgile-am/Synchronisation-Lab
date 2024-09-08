package org.ThreadControlandDeadlocks;

class SynchronizedCounter {
    private int count = 0;

    // Synchronized method
    public synchronized void incrementMethod() {
        count++;
    }

    // Synchronized block
    public void incrementBlock() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronisationExample {
    public static void runSynchronizedExamples() throws InterruptedException {
        SynchronizedCounter counter = new SynchronizedCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementMethod();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementBlock();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count after synchronized operations: " + counter.getCount());
    }
}
