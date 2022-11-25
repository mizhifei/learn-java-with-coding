package ch6.thread;

public class StopLittle {

    public static void main(String[] args) throws InterruptedException {
        printSlowly("太阳在这个平静的小村庄缓缓升起，又是开始了平常的一天。我们故事的主人公睡眼惺忪的起来", 300);
    }

    public static void printSlowly(String s, int i) throws InterruptedException {
        for (char c : s.toCharArray()) {
            Thread.sleep(i);
            System.out.print(c);
        }
    }
}
