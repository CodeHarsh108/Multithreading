package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    static Lock lock = new ReentrantLock();
    static int counter = 0;
    static void increment(){
        lock.lock();
        try{
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(Demo1::increment);
        Thread t2 = new Thread(Demo1::increment);
        t1.start();
        t2.start();

    }
}
