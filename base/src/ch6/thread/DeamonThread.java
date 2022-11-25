package ch6.thread;

import static ch6.thread.StopLittle.printSlowly;

public class DeamonThread {
    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) {

        System.out.println("Current thread is " + Thread.currentThread().getName());

        for (int i = 1; i <= 1; i++) {
            int fixedI = i;

            Thread thread = new Thread(() -> {
                System.out.println("执行这段代码的线程名字叫做" + Thread.currentThread().getName());
                try {
                    printSlowly(TEXT, 200 * fixedI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "执行结束");

            }, "My thread-" + i);

            thread.setDaemon(true);
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();

        }

        System.out.println("Frame thread is closed, it's name is " + Thread.currentThread().getName());
    }
}
