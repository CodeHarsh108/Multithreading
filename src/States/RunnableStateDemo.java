package States;
class RunnableStateDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try { Thread.sleep(2000); } catch (Exception e) {}
        });

        t.start();
        System.out.println("State: " + t.getState()); // RUNNABLE (or RUNNING)
    }
}

