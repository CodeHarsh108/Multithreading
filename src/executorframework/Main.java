package executorframework;

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
        Thread[] threads = new Thread[9];
        for (long i = 1; i < 10; i++) {
            long finalI = i;
            threads[(int) (i-1)] = new Thread(
                    () -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    }
            );
            threads[(int) (i-1)].start();

        }
        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Total time : " + (System.currentTimeMillis() - start));
    }
}
