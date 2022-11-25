package ch6.thread.sync;

public class DataHolder {

    private static long staticData = 0;
    private long data = 0;

    public synchronized void change(long data) {
        this.data += data;
    }

    public void blockChange(long data) {
        synchronized (this) {
            this.data += data;
        }
    }

    public static synchronized void staticChange(long data) {
        staticData += data;
    }

    public static void staticBlockChange(long data) {
        synchronized (DataHolder.class) {
            staticData += data;
        }
    }

    public void print() {
        System.out.println("Data = " + data);
    }

    public void printStatic() {
        System.out.println("Data = " + staticData);
    }
}
