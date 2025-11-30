package executorsframeworknew;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        Callable<String> t1 = () -> "Task 1 done";
        Callable<String> t2 = () -> "Task 2 done";
        Callable<String> t3 = () -> "Task 3 done";
        List<Callable<String>> tasks = Arrays.asList(t1, t2, t3);
//        List<Future<String>> results = service.invokeAll(tasks);
//        for(Future<String> f : results){
//            System.out.println(f.get());
//        }
        String result = service.invokeAny(tasks);
        System.out.println(result);
        service.shutdown();


    }
}
