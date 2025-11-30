package Semaphores;

import java.util.concurrent.Semaphore;

public class TryAcquire {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        if(semaphore.tryAcquire()){
            System.out.println("Got");
            semaphore.release();
        }else {
            System.out.println("No release");
        }
    }
}
