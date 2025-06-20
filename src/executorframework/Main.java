package executorframework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static long factorial(long n){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for(int i = 1; i <=n; i++){
            result *= i;
        }
        return result;
    }
    public static void main(String[] args)  {
        long start = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for (long i = 1; i < 10; i++) {
            long finalI = i;
            executorService.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });

        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total time : " + (System.currentTimeMillis() - start));
    }
}
