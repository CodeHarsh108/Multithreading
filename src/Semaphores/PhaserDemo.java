package Semaphores;

import java.util.concurrent.Phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + "Phase 0");
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " Phase 1");
            phaser.arriveAndAwaitAdvance();

            System.out.println(Thread.currentThread().getName() + " Phase 2");
            phaser.arriveAndAwaitAdvance();
        };


        new Thread(task, "T1").start();
        new Thread(task, "T2").start();
        new Thread(task, "T3").start();
    }
}
