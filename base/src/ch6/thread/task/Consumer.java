package ch6.thread.task;

import java.util.Queue;

public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks) {
        this.tasks = tasks;
    }

    public T consume() throws InterruptedException {
        synchronized (tasks) {
            while (tasks.size() == 0) {
                System.out.println("-" + App.getName() + "：队列" + tasks + "为🈳️，进入等待：");
                tasks.wait();
                System.out.println("-" + App.getName() + "：获得通知，结束等待：");
            }
            T poll = tasks.poll();
            System.out.println("+" + App.getName() + "：成功消费 " + poll + "，队列还有" + tasks);
            tasks.notifyAll();
            return poll;
        }
    }
}
