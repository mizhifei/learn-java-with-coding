package ch4.generic;

public class Pair<T> {

    private T first;

    private T last;

    public Pair() {
    }

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public static void set(Pair<? super Integer> p, Integer first, Integer last) {
        p.setFirst(first);
        p.setLast(last);
    }

    public static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }
}
