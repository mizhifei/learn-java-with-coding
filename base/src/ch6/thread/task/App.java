package ch6.thread.task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class App {

    public static final Object ticket = new Object();

    public static void main(String[] args) {
        Queue<String> urls = new LinkedList<>();

        Consumer<String> stringConsumer = new Consumer<>(urls);
        Producer<String> stringProducer = new Producer<>(urls, 10);

        for (int i = 0; i < 5; i++) {
            Thread consumerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = stringConsumer.consume();
                        processURL(url);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, "消费者" + i);
            consumerThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread producerThread = new Thread(() -> {
                while (true) {
                    try {
                        String url = produceURL();
                        stringProducer.produce(url);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }, "生产者" + i);
            producerThread.start();
        }

    }

    private static String produceURL() {
        StringBuilder ret = new StringBuilder();
        ret.append("www.");
        for (int i = 0; i < 6; i++) {
            int rand = ((int) (Math.random() * 100)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        ret.append(".com");
        return ret.toString();
    }

    private static void processURL(String url) throws InterruptedException {
        System.out.println("-" + getName() + "开始处理：" + url);
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        System.out.println("-" + getName() + "处理完成：" + url);
    }
    public static String getName() {
        return Thread.currentThread().getName();
    }
}
