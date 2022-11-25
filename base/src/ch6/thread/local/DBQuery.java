package ch6.thread.local;

import java.util.concurrent.TimeUnit;

public class DBQuery {
    public void query() {
        PerformanceTracker.startPhase();

        try {
            Thread.sleep((int) (Math.random() * TimeUnit.SECONDS.toMillis(2)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceTracker.endPhase("DBQuery");

    }
}
