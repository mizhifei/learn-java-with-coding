package ch6.thread.deadlock;

import static ch6.thread.deadlock.App.decsWorkflow;

public class Task2 implements Runnable {
    private AppResources resources;

    public Task2(AppResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {

//        acsWorkflow(resources);
        decsWorkflow(resources);
    }
}
