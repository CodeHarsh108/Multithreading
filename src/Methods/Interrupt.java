package Methods;

public class Interrupt {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(() -> {
            try{
                System.out.println("Thread Sleeping");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        });
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }
}
