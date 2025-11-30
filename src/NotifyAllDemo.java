public class NotifyAllDemo {
    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        Runnable waiter = () -> {
          synchronized (LOCK){
              System.out.println(Thread.currentThread().getName() + ": Waiting...");
              try{
                  LOCK.wait();
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
              System.out.println(Thread.currentThread().getName() + ": Woken Up!!");
          }
        };

        Thread t1 = new Thread(waiter, "T1");
        Thread t2 = new Thread(waiter, "T2");

        Thread notifier = new Thread(() -> {
            synchronized (LOCK){
                System.out.println("Notifier waking up all thread");
                LOCK.notifyAll();
            }
        });

        t1.start();
        t2.start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifier.start();

    }
}
