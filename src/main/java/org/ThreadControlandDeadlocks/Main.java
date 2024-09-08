package org.ThreadControlandDeadlocks;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello and welcome to the Synchronisation lab!");

        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        // Example usage of synchronized blocks and methods
        SynchronisationExample.runSynchronizedExamples();
        SynchronisationDeadlock.runDeadlockExample();
        SynchronisationLocks.runLocksExample();
        SynchronisationAtomic.runAtomicExample();
    }
}
