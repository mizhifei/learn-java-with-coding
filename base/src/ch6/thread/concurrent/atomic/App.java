package ch6.thread.concurrent.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class App {
    private AtomicLong atomicLong = new AtomicLong();
    private volatile long vLong;

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        int loop = Integer.MAX_VALUE / 100;

        int parallel = 10;

        List<Thread> atomicThreads = new ArrayList<>();

        for (int i = 0; i < parallel; i++) {
            int loopCount = loop / parallel;
            if (i == parallel - 1) {
                loopCount = loop - (loop / parallel) * (parallel - 1);
            }

            int finalLoopCount = loopCount;

            Thread atomicThread = new Thread(() -> {
                long start = System.currentTimeMillis();
                for (int j = 0; j < finalLoopCount; j++) {
                    app.atomicLong.incrementAndGet();
                }
                System.out.println("Atomic takes " + (System.currentTimeMillis() - start));
            });
            atomicThread.start();
            atomicThreads.add(atomicThread);
        }


        Thread mainThread = new Thread(() -> {
            long start = System.currentTimeMillis();

            for (int i = 0; i < loop; i++) {
                app.vLong++;
            }

            System.out.println("Main thread takes " + (System.currentTimeMillis() - start));
        });
        mainThread.start();

        for (Thread atomicThread : atomicThreads) {
            atomicThread.join();
        }
        mainThread.join();
        System.out.println(app);
    }

    @Override
    public String toString() {
        return "App{" +
                "atomicLong=" + atomicLong +
                ", vLong=" + vLong +
                '}';
    }
}
