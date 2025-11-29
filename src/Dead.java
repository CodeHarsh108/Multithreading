public class Dead {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA){

                System.out.println("Thread 1 : Holding lock A...");

                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 1 : Waiting for lock B...");

                synchronized (lockB){
                    System.out.println("Thread 1 : Got lock B...");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB){

                System.out.println("Thread 2 : Holding lock B...");

                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Thread 2 : Waiting for lock A...");

                synchronized (lockA){
                    System.out.println("Thread 2: Got lock A...");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
