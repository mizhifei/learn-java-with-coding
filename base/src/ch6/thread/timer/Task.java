package ch6.thread.timer;

import java.util.TimerTask;

public class Task extends TimerTask {
    private long times;

    @Override
    public void run() {
        System.out.println(times++);
    }
}
