package ch4.generic;

public class Limiting {

    public static void main(String[] args) {
        Pair strings = new Pair<Double>();
        Pair integers = new Pair<Integer>();

        boolean b = strings.getClass() == integers.getClass();

        System.out.println(b);


        System.out.println(strings instanceof Pair<?>);




    }
}
