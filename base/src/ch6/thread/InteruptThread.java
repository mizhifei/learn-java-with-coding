package ch6.thread;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class InteruptThread {

    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) throws InterruptedException {

        System.out.println("程序开始，执行的线程名字叫做" + Thread.currentThread().getName());

        ArrayList<Thread> threads = new ArrayList<>();
        long duration = TimeUnit.SECONDS.toMillis(8);
        for (int i = 1; i <= 1; i++) {

            int fixedI = i;

            Thread thread = new Thread(() -> {
                System.out.println("执行开始,线程名字叫做" + Thread.currentThread().getName());

                long start = System.currentTimeMillis();
                long counter = 0;
                boolean interrupted = Thread.currentThread().isInterrupted();

                System.out.println(Thread.currentThread().getName() + "的isInterrupted=" + interrupted);

                while (true) {
                    counter++;
                    if (interrupted != Thread.currentThread().isInterrupted()) {
                        interrupted = Thread.currentThread().isInterrupted();

                        System.out.println("发现线程" + Thread.currentThread().getName() + "的isInterrupted变化为：" + interrupted + ", counter is " + counter);
                        System.out.println("但是线程决定什么都不做");
                    }
                    if (System.currentTimeMillis() - start > duration) {
                        break;
                    }
                }
                System.out.println(Thread.currentThread().getName() + "执行结束");

            }, "My thread-" + i);

            thread.start();
            threads.add(thread);
        }

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        System.out.println();
        System.out.println("开始 interrupt 线程");

        threads.forEach(Thread::interrupt);

        System.out.println("interrupt 线程结束，继续sleep 五秒钟");

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));

        System.out.println("启动线程结束，名字叫做" + Thread.currentThread().getName());
    }
}
