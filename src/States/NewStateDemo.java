package States;

class NewStateDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Running..."));

        System.out.println("State: " + t.getState()); // NEW
    }
}

