package ch7.util.collection;

import java.util.*;

public class QueueAndList {
    public static void main(String[] args) {
        // list
        List<String> stringList = new ArrayList<>();
        stringList.add("123");


        List<Integer> integerVector = new Vector<>();
        integerVector.add(1);
        Vector<Integer> stack = new Stack<>();
        stack.add(1);

        // queue
        Queue<String> stringPriorityQueue = new PriorityQueue<>();
        stringPriorityQueue.add("123");

        // Queue > Deque > ArrayDeque
        Queue<Integer> integerQueue = new ArrayDeque<>();
        System.out.println(integerQueue instanceof Deque<Integer>);

        //   Deque        List
        //      \         /
        //       \       /
        //        v     v
        //      LinkedList
        Collection<Float> floatLinkedList = new LinkedList<>();
        System.out.println(floatLinkedList instanceof Deque<Float>);
        System.out.println(floatLinkedList instanceof List);

    }
}
