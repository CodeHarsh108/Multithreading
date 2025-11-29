package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo3 {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        if(lock.tryLock(3, TimeUnit.SECONDS)){
            try{
                System.out.println("Lock Acquired");
            }finally {
                lock.unlock();
            }
        }else {
            System.out.println("Could not get the lock");
        }
    }
}
