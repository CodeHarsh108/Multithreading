public class WaitNotifyDemo {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {


        Thread t1 = new Thread(() -> {
            synchronized (LOCK){
                System.out.println("T1 : Going to wait...");
                try{
                    LOCK.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("T1 got notified!! Resumed.");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK){
                System.out.println("T2 Notifying T1...");
                LOCK.notify();
                System.out.println("T2 Notification sent");
            }
        });

        t1.start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }
}
