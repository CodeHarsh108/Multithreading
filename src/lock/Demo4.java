package lock;

import java.util.concurrent.locks.*;

class Demo4 {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                lock.lockInterruptibly();  // can be interrupted
                try {
                    System.out.println("Got lock!");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting for lock");
            }
        });

        lock.lock(); // main thread takes lock

        t.start();   // t will wait

        t.interrupt();  // interrupt waiting thread
    }
}
