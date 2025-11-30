package executorsframeworknew;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {
    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            int task = i;
            e.submit(() -> {
                System.out.println(task);
            });
        }
        e.shutdown();
    }
}
