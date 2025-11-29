package Threads;

class Mythread implements Runnable{
    @Override
    public void run(){
        System.out.println("Running");
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread t = new Thread(new Mythread());
        t.start();
    }

}
