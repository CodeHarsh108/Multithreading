package executorframework;

public class Main {
    public static long factorial(long n){
        long result = 1;
        for(int i = 1; i <=n; i++){
            result *= i;
        }
        return result;
    }
    public static void main(String[] args) {
        for (long i = 1; i < 10; i++) {
            System.out.println(factorial(i));
        }
    }
}
