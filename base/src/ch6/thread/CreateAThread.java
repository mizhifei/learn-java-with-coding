package ch6.thread;

public class CreateAThread {
    private static final String TEXT = "太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来\n" +
            "......";

    public static void main(String[] args) {
        System.out.println("Current thread is " + Thread.currentThread().getName());

        for (int i = 1; i <= 2; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                double num = Math.random();
                System.out.println("执行这段代码的线程名字叫做" + Thread.currentThread().getName()+", Random number is " + num);
                try {
                    StopLittle.printSlowly(TEXT, 200 * finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "执行结束");

            }, "My thread-" + i);
            thread.start();

        }
        System.out.println("启动线程结束，名字叫做" + Thread.currentThread().getName());


    }
}
