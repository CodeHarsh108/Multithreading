package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        if(lock.tryLock()){
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
