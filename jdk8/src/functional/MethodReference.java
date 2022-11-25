package functional;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        String[] arr = new String[]{"a", "b","c", "1", "2"};
        Arrays.sort(arr, String::compareTo);

        System.out.println(arr);

        List<String> people = List.of("Alice", "Bob");


    }
}
