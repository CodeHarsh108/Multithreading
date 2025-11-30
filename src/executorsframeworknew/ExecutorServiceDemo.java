package executorsframeworknew;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ExecutorService e = Executors.newSingleThreadExecutor();
        e.submit(() -> {
            System.out.println("Hello");
        });
        e.shutdown();
    }
}
