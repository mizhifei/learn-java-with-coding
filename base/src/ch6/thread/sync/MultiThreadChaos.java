package ch6.thread.sync;

public class MultiThreadChaos {
    public static void main(String[] args) {

        DataHolder dataHolder = new DataHolder();
        Thread plusThread = new Thread((new DataChangeRunner(3, Integer.MAX_VALUE/50, dataHolder)), "runner-plus");
        plusThread.start();

        DataHolder dataHolder2 = new DataHolder();
        Thread minusThread = new Thread((new DataChangeRunner(-3, Integer.MAX_VALUE/50, dataHolder)), "runner-minus");
//        Thread minusThread = new Thread((new DataChangeRunner(-3, Integer.MAX_VALUE/50, dataHolder2)), "runner-minus");
        minusThread.start();
    }
}
