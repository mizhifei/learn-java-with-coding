package ch6.thread.concurrent.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> running = executorService.submit(() -> {
            printExecutionThreadStatus("running");
        });

        System.out.println("已经提交run task");

        Future<String> calling = executorService.submit(() -> {
            printExecutionThreadStatus("calling");
            return "result";
        });
        System.out.println("已经提交call task");

        System.out.println("任务提交完毕");
        System.out.println("关闭线程池");
        executorService.shutdown();


        System.out.println("开始获取call task的执行结果");
        String result = calling.get();
        System.out.println("获取到了任务执行的结果，为：" + result);

    }

    private static void printExecutionThreadStatus(String status) {
        System.out.println(Thread.currentThread().getName() + ":在线程池里执行的代码：" + status);

    }
}
