package ch6.thread.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 3; i++) {
            new Thread(new LockWorker(reentrantLock), "Worker-" + i).start();
        }
    }
}
