package Methods;

public class Join {
    public static void main(String[] args) throws Exception{
        Thread t = new Thread(() -> {
            System.out.println("Child thread running");
        });
        t.start();
        t.join(); // main waits here

        System.out.println("Parent after child");


    }
}
