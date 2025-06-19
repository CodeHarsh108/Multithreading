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
        for (long i = 1; i < 10; i++) {
            System.out.println(factorial(i));
        }
        System.out.println("Total time : " + (System.currentTimeMillis() - start));
    }
}
