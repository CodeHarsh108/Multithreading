package States;
class TimedWaitingDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            try { Thread.sleep(5000); } catch (Exception e) {}
        });

        t.start();
        Thread.sleep(100);
        System.out.println("State: " + t.getState());  // TIMED_WAITING
    }
}

