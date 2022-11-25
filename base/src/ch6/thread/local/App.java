package ch6.thread.local;

public class App {

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " start……");
                PerformanceTracker.reset();

                InputHandler inputHandler = new InputHandler();
                String content = inputHandler.getInput();

                DBQuery query = new DBQuery();
                query.query();

                ConentProcess conentProcess = new ConentProcess();
                conentProcess.process(content);

                PerformanceTracker.finish();
                System.out.println(Thread.currentThread().getName() + " end……");

            }, "Thread-" + i);
            thread.start();
        }
    }
}
