import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock = new ReentrantLock();
    public void outer(){
        lock.lock();
        try{
            System.out.println("Outer");
            inner();
        }finally {
            lock.unlock();
        }
    }

    private void inner() {
        lock.lock();
        try{
            System.out.println("Inner");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample ex = new ReentrantExample();
        ex.outer();
    }
}
