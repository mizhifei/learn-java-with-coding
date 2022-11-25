package ch6.thread.timer;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Task(),0, TimeUnit.SECONDS.toMillis(1));

//        Thread timerThread = new Thread("Timer Thread");
//        Task task = new Task();
//        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1, r -> {
//            return timerThread;
//        });
//        executorService.scheduleAtFixedRate(task,0,5, TimeUnit.SECONDS);
//        timerThread.join();
    }
}
