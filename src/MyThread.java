public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i =0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + " is running");
            Thread.yield();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Harsh");
        MyThread t2 = new MyThread("Patil");
        t1.start();
        t2.start();
    }
}
