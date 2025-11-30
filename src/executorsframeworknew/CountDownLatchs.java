package executorsframeworknew;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchs {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("1");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("2");
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("3");
            countDownLatch.countDown();
        }).start();

        System.out.println("Main waiting");
        countDownLatch.await();
        System.out.println("Main continues");

    }
}
