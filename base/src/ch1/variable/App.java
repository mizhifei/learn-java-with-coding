package ch1.variable;

public class App {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;

        int x = 4;

        int y = a * x + b * (x * x) + c * (x * x * x);

        System.out.println(y);
    }
}
