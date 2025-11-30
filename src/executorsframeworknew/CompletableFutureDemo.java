package executorsframeworknew;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10 * 30);
        System.out.println(future.join());
    }
}
