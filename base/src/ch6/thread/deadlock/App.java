package ch6.thread.deadlock;

import java.util.concurrent.TimeUnit;

import static ch6.thread.task.App.getName;

public class App {

    public static void main(String[] args) throws InterruptedException {
        AppResources resources = new AppResources();
        Thread task1 = new Thread(new Task1(resources), "Task-1");
        task1.start();
        Thread task2 = new Thread(new Task2(resources), "Task-2");
        task2.start();
        task1.join();
        task2.join();
        System.out.println("Finished");
    }


    public static void acsWorkflow(AppResources resources) {
        synchronized (resources.getDocument()) {
            System.out.println(getName() + "得到了Document资源");
            System.out.println(getName() + "开始工作……");

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "尝试去获取Printer资源");
            synchronized (resources.getPrinter()) {
                System.out.println(getName() + "得到了Printer资源");
                System.out.println(getName() + "继续工作……");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void decsWorkflow(AppResources resources) {
        synchronized (resources.getPrinter()) {
            System.out.println(getName() + "得到了Printer资源");
            System.out.println(getName() + "开始工作……");

            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(2));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "尝试去获取Document资源");
            synchronized (resources.getDocument()) {
                System.out.println(getName() + "得到了Document资源");
                System.out.println(getName() + "继续工作……");
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
