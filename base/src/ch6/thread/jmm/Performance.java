package ch6.thread.jmm;

public class Performance {
    public long count;
    public volatile long safeCount;

    public static void main(String[] args) {
        int loop = Integer.MAX_VALUE / 30;
        Performance performance = new Performance();
        new Thread(()->{
            long start = System.currentTimeMillis();
            for (int i = 0; i < loop; i++) {
                performance.count++;
            }
            System.out.println("Normal count spend " + (System.currentTimeMillis() - start));
        }, "normal count").start();

        new Thread(()->{
            long start = System.currentTimeMillis();
            for (int i = 0; i < loop; i++) {
                performance.safeCount++;
            }
            System.out.println("Safe count spend " + (System.currentTimeMillis() - start));
        }, "Safe count").start();
    }
}
