package ch6.thread.concurrent.condition;

import ch6.thread.task.App;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WaitApp {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        int workingSeconds = 2;
        int threadCount = 3;
        for (int i = 0; i < threadCount; i++) {
            new Thread(()->{

                System.out.println(App.getName() + "：线程开始工作……");
                reentrantLock.lock();
                try {
                    sleepSec(workingSeconds);
                    System.out.println(App.getName() + "：进入等待");
                    condition.await();
                    System.out.println(App.getName() + "：线程继续……");

                    sleepSec(2);
                    System.out.println(App.getName() + "：结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    reentrantLock.unlock();
                }
            }, "Worker-"+i).start();
        }

        System.out.println("------------- 唤醒线程开始sleep -------------");
        sleepSec(workingSeconds + 1);
        System.out.println("------------- 唤醒线程sleep结束 -------------");
        reentrantLock.lock();
        try {
            System.out.println("------------- 开始唤醒所有 -------------");
            condition.signalAll();

        } finally {
            reentrantLock.unlock();
        }

    }

    private static void sleepSec(int workingSeconds) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(workingSeconds));
    }
}
