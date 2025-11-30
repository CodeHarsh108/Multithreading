package Semaphores;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {
    static Semaphore empty = new Semaphore(1);
    static Semaphore full = new Semaphore(0);
    static int data;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try{
                empty.acquire();
                data = 99;
                System.out.println("Produced "+data);
                full.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread consumer = new Thread(() -> {
            try{
                full.acquire();
                System.out.println("Consumed " + data);
                empty.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();
    }
}
