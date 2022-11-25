package ch6.thread.sync;

public class DataChangeRunner implements Runnable {

    private long step;

    private long loopTimes;

    private DataHolder dataHolder;

    public DataChangeRunner(long step, long loopTimes, DataHolder dataHolder) {
        this.step = step;
        this.loopTimes = loopTimes;
        this.dataHolder = dataHolder;
    }

    @Override
    public void run() {
        for (int i = 0; i < loopTimes; i++) {
            dataHolder.change(step);
//            DataHolder.staticChange(step);
        }
        dataHolder.print();
//        dataHolder.printStatic();
    }
}
