package Semaphores;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        Runnable task = () -> {
            try{
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + "acquired");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + "leaving");
                semaphore.release();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
        for(int i = 1; i <= 5; i++){
            new Thread(task, "T"+i).start();
        }
    }
}
