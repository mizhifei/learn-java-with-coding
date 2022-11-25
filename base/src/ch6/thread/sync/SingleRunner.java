package ch6.thread.sync;

public class SingleRunner {
    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder();
        DataChangeRunner plusDataChangeRunner = new DataChangeRunner(3, Integer.MAX_VALUE, dataHolder);
        plusDataChangeRunner.run();
        DataChangeRunner minusDataChangeRunner = new DataChangeRunner(-3, Integer.MAX_VALUE, dataHolder);
        minusDataChangeRunner.run();
    }
}
