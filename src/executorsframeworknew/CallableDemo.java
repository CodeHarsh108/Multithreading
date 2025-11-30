package executorsframeworknew;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> 10 + 20;
        Future<Integer> result = service.submit(task);
        System.out.println(result.get());
        service.shutdown();
    }
}
