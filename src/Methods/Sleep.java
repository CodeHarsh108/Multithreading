package Methods;

public class Sleep {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try{
            System.out.println("Starts");
            Thread.sleep(10000);
            System.out.println("Ends");} catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }
}
