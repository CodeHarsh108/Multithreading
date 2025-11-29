package Threads;

class Demo extends Thread{
    public void run(){
        System.out.println("Running");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.start();
    }
}
