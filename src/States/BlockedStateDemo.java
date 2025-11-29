package States;
class BlockedStateDemo {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try { Thread.sleep(5000); } catch (Exception e) {}
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (LOCK) { }
        });

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);

        System.out.println("State of t2: " + t2.getState()); // BLOCKED
    }
}

