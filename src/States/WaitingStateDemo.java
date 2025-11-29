package States;

class WaitingStateDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            try { Thread.sleep(3000); } catch (Exception e) {}
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // t2 will go to WAITING
            } catch (Exception e) {}
        });

        t1.start();
        t2.start();

        Thread.sleep(100);
        System.out.println("State of t2: " + t2.getState()); // WAITING
    }
}
