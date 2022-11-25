package ch4.generic;

public class WatchOut {

    public static void main(String[] args) {
        Pair[] arr = new Pair[2];
        Pair<String>[] ps = (Pair<String>[]) arr;

        ps[0] = new Pair<>("a", "b");
        arr[1] = new Pair<>(1, 2);

// ClassCastException:
        Pair<String> p = ps[1];
        String s = p.getFirst();
    }
}
