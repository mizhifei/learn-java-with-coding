package ch6.thread.jmm;

public class App {

    public static void main(String[] args) {
        DataCounter dataCounter = new DataCounter();
        Thread threadChanger = new Thread(() -> {
            while (true) {
                dataCounter.changData();
            }
        }, "Thread Changer");
        threadChanger.start();
        Thread checker = new Thread(() -> {
            while (true) {
                dataCounter.check();
            }
        }, "Thread Checker");
        checker.start();

    }
}
