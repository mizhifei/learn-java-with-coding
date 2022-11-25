package ch6.thread.concurrent.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockWorker implements Runnable {

    private Lock lock;

    public LockWorker(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            try {
                if (lock.tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        printLockStatus("start");
                        stage1();
                    } finally {
                        lock.unlock();
                        printLockStatus("Finished");
                    }
                } else {
                    printLockFailure();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void printLockFailure() {
        System.out.println(Thread.currentThread().getName() + " failed to get lock");
    }

    private void stage1() {
        lock.lock();
        try {
            printLockStatus("stage1");
            stage2();
        } finally {
            lock.unlock();
            printLockStatus("Stage1 Finished");
        }

    }

    private void stage2() {
        lock.lock();
        try {
            printLockStatus("Stage2");
            stage3();
        } finally {
            lock.unlock();
            printLockStatus("Stage3 Finished");
        }

    }

    private void stage3() {
        lock.lock();
        try {
            printLockStatus("stage3");
        } finally {
            lock.unlock();
            printLockStatus("Stage3 Finished");
        }
    }

    private void printLockStatus(String stage) {
        System.out.println(Thread.currentThread().getName() + " " + stage
                + " hold count = " + ((ReentrantLock) lock).getHoldCount());
    }
}
