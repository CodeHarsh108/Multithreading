package executorsframeworknew;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        for(int i = 1; i <=5 ; i++){
            int taskNo = i;
            pool.submit(() -> {
                System.out.println(taskNo);
            });
        }
        pool.shutdown();
    }
}
