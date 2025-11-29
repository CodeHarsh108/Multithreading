package Methods;

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Running");
    }
}

public class RunAndStart {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start();
    }
}
