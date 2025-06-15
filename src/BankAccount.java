public class BankAccount {
    private int balance = 100;
    public synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);
        if (balance >= amount){
            System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal ");
            Thread.sleep(10000);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal, Remaining balance : " + balance);
        }else{
            System.out.println(Thread.currentThread().getName() + " insufficient balance ");
        }
    }
}
