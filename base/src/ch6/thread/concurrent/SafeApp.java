package ch6.thread.concurrent;

import sun.misc.Unsafe;

public class SafeApp {
    public static void main(String[] args) {
        Unsafe unsafe = null;
        unsafe.park(true, 1);
        unsafe.unpark(null);
    }
}
