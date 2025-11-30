package Semaphores;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try{
                String data = "Data from t1";
                System.out.println("T1 sending data :" + data);
                String received = exchanger.exchange(data);
                System.out.println("T1 received : " + data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(() -> {
            try{
                String data = "Data from t2";
                System.out.println("T2 sending data :" + data);
                String received = exchanger.exchange(data);
                System.out.println("T2 received : " + data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
