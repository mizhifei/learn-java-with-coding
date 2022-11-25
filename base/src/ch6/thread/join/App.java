package ch6.thread.join;

import java.util.ArrayList;
import java.util.List;

public class App {


    private static final List<String> CONTENTS = new ArrayList<>();

    private static long WORKING_DURATION = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(ch6.thread.task.App.getName() + ":开始抓取网页内容");
                long begin = System.currentTimeMillis();
                String content = getContentFromWeb();
                long threadWorkingDuration = System.currentTimeMillis() - begin;
                System.out.println(ch6.thread.task.App.getName() + ":抓取网页内容结束");
                synchronized (CONTENTS) {
                    CONTENTS.add(content);
                    WORKING_DURATION += threadWorkingDuration;
                }

            }, "Thread-" + i);

            thread.start();
            threads.add(thread);

        }
        Thread.sleep(1);


        System.out.println(" ------------ 主线程开始 join  ------------ ");

        for (Thread thread : threads) {
            String name = thread.getName();
            System.out.println(" ------------ 主线程开始join " + name + " ------------ ");
            thread.join();
            System.out.println(" ------------ 主线程join " + name + " 结束 ------------ ");
        }
        System.out.println(" ------------ 主线程join结束，获取的内容为： ------------ ");

        CONTENTS.forEach(s -> {
            System.out.print(s.length() + "：");
            System.out.println(s);
        });


        long mainWorkDuration = System.currentTimeMillis() - start;


        System.out.println("工作线程累计工作时间：" + WORKING_DURATION);
        System.out.println("主线程工作时间：" + mainWorkDuration);
    }


    public static String getContentFromWeb() {
        StringBuilder ret = new StringBuilder();
        int len = ((int) (Math.random() * 1000000)) % 4096 + 1024;
        for (int i = 0; i < len; i++) {
            int rand = ((int) (Math.random() * 100)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return ret.toString();
    }
}
