import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;
    private final Lock lock = new ReentrantLock();
    public  void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){
            if (balance >= amount){
                try{
                System.out.println(Thread.currentThread().getName() + " processing");
                Thread.sleep(3000);
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " completed");} catch (Exception e) {
                    Thread.currentThread().interrupt();
                }finally {
                    lock.unlock();
                }
            }else{
                System.out.println(Thread.currentThread().getName() + " insufficient balance");
            }
        }else{
            System.out.println(Thread.currentThread().getName() + " try later");
        }
    }
}
