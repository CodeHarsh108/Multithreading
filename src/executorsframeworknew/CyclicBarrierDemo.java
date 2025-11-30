package executorsframeworknew;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "reached checkpoint");
            try{
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();



    }
}
