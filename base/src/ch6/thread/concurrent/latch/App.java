package ch6.thread.concurrent.latch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class App {

    private static final List<String> CONTENTS = new ArrayList<>();

    private static long WORKING_DURATION;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        long mainStart = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + ":Start working...");
                long start = System.currentTimeMillis();
                String content = ch6.thread.join.App.getContentFromWeb();
                long threadWorkingDuration = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + ":Work finished...");
                synchronized (CONTENTS) {
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkingDuration;
                }
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "Ended...");

            }, "Thread-" + i);
            thread.start();
        }
        countDownLatch.await();
        CONTENTS.forEach(s -> {
            System.out.println(s.length() + ":" + s);
        });

        long mainDuration = System.currentTimeMillis() - mainStart;
        System.out.println("Total Threads time: " + WORKING_DURATION);
        System.out.println("Total spend time:" + mainDuration);
        System.out.println("All ended!");

    }
}
