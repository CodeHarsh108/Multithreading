package lock;

import java.util.concurrent.locks.*;

class Demo5 {
    static Lock lock = new ReentrantLock(true); // FAIR LOCK

    static void task() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " got lock");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            new Thread(Demo5::task, "T" + i).start();
        }
    }
}
