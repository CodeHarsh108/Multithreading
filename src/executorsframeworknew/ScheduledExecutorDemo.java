package executorsframeworknew;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(()->{
            System.out.println("Hello");
        }, 3, TimeUnit.MILLISECONDS);
        service.shutdown();
    }

}
