package ch6.thread.jmm;

public class DataCounter {
//    int a, b, c, d, f, g;
    volatile int a, b, c, d, f, g;

    long e;
//    volatile long e;

    public void changData() {
        a += 1;
        b += 1;
        c += 1;
        d += 1;

        e += 1;

        f += 1;
        g += 1;
    }

    int counter;


    public void check() {
        if (g > e) {
            System.out.println("got it, round " + counter++);
        }
    }


}
