public class MyThread extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            String a = " ";
            for(int j = 0; j < 100000; j++){
                a += "a";
            }
            System.out.println(Thread.currentThread().getName() + " Priority : " + Thread.currentThread().getPriority() + " count " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread l = new MyThread("Low");
        Thread m = new Thread("Medium");
        Thread h = new Thread("High");
        l.setPriority(MIN_PRIORITY);
        m.setPriority(NORM_PRIORITY);
        h.setPriority(MAX_PRIORITY);
        l.start();
        m.start();
        h.start();
    }
}
