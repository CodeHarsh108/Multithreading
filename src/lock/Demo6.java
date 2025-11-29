package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Data{
    private int value = 0;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock read = readWriteLock.readLock();
    private Lock write = readWriteLock.writeLock();

    void writeData(int newValue){
        write.lock();
        try{
            System.out.println("Writing " + newValue);
            value = newValue;
        }finally {
            write.unlock();
        }
    }

    void readData(){
        read.lock();
        try{
            System.out.println("Reading " + value);
        }finally {
            read.unlock();
        }
    }
}

public class Demo6 {
    public static void main(String[] args) {
        Data d = new Data();

        new Thread(d::readData).start();
        new Thread(d::readData).start();

        new Thread(() -> d.writeData(100)).start();
    }
}
