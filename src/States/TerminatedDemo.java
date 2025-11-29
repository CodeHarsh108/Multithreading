package States;
class TerminatedDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> System.out.println("Done!"));

        t.start();
        Thread.sleep(100);

        System.out.println("State: " + t.getState()); // TERMINATED
    }
}

