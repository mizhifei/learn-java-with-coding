package ch4.generic;

public class Supe {

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>();
        Pair.set(pair, 1, 2);
        Integer first = pair.getFirst();
        System.out.println(first);

    }
}
