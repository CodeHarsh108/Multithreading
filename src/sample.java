import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class sample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing the task");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        pool.submit(task);
        pool.submit(task);
        pool.submit(task);
        pool.submit(task);

        pool.shutdown();
    }
}
