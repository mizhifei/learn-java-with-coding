package ch6.thread.task;

import java.util.Queue;

public class Producer<T> {
    private Queue<T> tasks;

    private int maxTasksCount;

    public Producer(Queue<T> tasks, int maxTasksCount) {
        this.tasks = tasks;
        this.maxTasksCount = maxTasksCount;
    }

    public void produce(T task) throws InterruptedException {
        synchronized (tasks) {
            while (tasks.size() >= maxTasksCount) {
                System.out.println("+" + App.getName() + "：队列" + tasks + "饱和，进入等待：");
                tasks.wait();
                System.out.println("+" + App.getName() + "：获得通知，结束等待：");
            }
            tasks.add(task);
            System.out.println("+" + App.getName() + "：成功添加 " + task + "，队列还有" + tasks);
            tasks.notifyAll();
        }
    }
}
