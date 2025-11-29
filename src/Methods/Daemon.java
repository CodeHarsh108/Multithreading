package Methods;

import java.sql.SQLOutput;

public class Daemon {
    public static void main(String[] args) {
        Thread user = new Thread(() -> {
            System.out.println("Start");
            try{
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            System.out.println("End");
        });

        Thread daemon = new Thread(() -> {
            while (true){
                System.out.println("Daemon working...");
            }
        });

        daemon.setDaemon(true);

        user.start();
        daemon.start();
    }
}
