package ch4.generic;

public class Extend {

    public static void main(String[] args) {

        Pair<Integer> pair = new Pair<>(1, 2);

        int add = Pair.add(pair);

        System.out.println(add);

    }
}
