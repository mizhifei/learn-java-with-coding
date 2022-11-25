package ch6.thread.deadlock;

public class Task1 implements Runnable {

    private AppResources resources;

    public Task1(AppResources resources) {
        this.resources = resources;
    }

    @Override
    public void run() {
        App.acsWorkflow(resources);
    }
}
