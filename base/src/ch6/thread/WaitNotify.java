package ch6.thread;

import java.util.concurrent.TimeUnit;

public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Object ticket = new Object();

        int workingSeconds = 2;
        int threadCount = 5;

        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(getName() + "：到达面试厅外面，排队拿ticket……");
                synchronized (ticket) {
                    try {
                        System.out.println(getName() + "：拿到面试ticket，进入面试厅开始面试……");
                        sleepSeconds(workingSeconds);
                        System.out.println(getName() + "：从面试厅面试完出来，归还ticket，进入wait状态，等待面试结果notify");
                        ticket.wait();
                        System.out.println(getName() + "：收到领取面试结果notify，wait结束，重新拿到ticket，进入面试厅获取面试结果……");
                        sleepSeconds(workingSeconds);
                        System.out.println(getName() + "：获得面试结果，从面试厅出来，归还ticket……");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }, "面试者" + i).start();
        }

        System.out.println("------------- 前台在前台位置等第一个面试者面试结束之后才能进入面试厅获取面试结果 -------------");

        sleepSeconds(workingSeconds + 1);
        System.out.println("------------- 前台，等待结束，排队拿ticket进入面试厅 -------------");

        synchronized (ticket) {
            System.out.println("------------- 前台拿到ticket，进入面试厅拿到面试结果，开始广播notify通知所有面试者领取面试结果 -------------");
            ticket.notifyAll();
//            for (int i = 0; i < threadCount; i++) {
//                System.out.println("------------- 开始逐个唤醒 -------------");
//                locker.notify();
//            }
            System.out.println("------------- 前台归还ticket，从面试厅出来 -------------");
        }


    }

    private static void sleepSeconds(int workingSeconds) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(workingSeconds));
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
