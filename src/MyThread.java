public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        while(true){
            System.out.println("Hello!!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Harsh");
        t1.setDaemon(true);
        t1.start();
        System.out.println("Main Done");

    }
}
