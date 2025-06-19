package executorframework;

public class Main {
    public static long factorial(long n){
        long result = 1;
        for(int i = 1; i <=n; i++){
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) throws InterruptedException {
        for (long i = 1; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(factorial(i));
        }
    }
}
