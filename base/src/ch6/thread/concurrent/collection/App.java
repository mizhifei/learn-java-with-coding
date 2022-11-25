package ch6.thread.concurrent.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class App {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(128);

        Integer peek = queue.peek();

        System.out.println(peek);

        for (int i = 0; i < 3; i++) {
            boolean offer = queue.offer(i);
            System.out.println("Offer " + i + " succeed? " + offer);
        }

        for (int i = 0; i < 3; i++) {
            Integer poll = queue.poll();
            System.out.println("Poll " + poll + " succeed");
        }


        for (int i = 0; i < 3; i++) {
            queue.put(i);
            System.out.println("Puted " + i);
        }

        for (int i = 0; i < 3; i++) {
            Integer take = queue.take();
            System.out.println("Take " + take + " succeed");
        }

        ConcurrentHashMap<String, List<Integer>> map = new ConcurrentHashMap<>(128);
        String k1 = "k1";
        List<Integer> put = map.put(k1, new ArrayList<>());
        System.out.println("put:" + map.get(k1));

        ArrayList<Integer> integers = new ArrayList<>();
        boolean add = integers.add(999);
        map.putIfAbsent(k1, integers);
        System.out.println("putIfAbsent:" + map.get(k1));

        map.compute(k1, (k, v) -> {
            v.add(1);
            return v;
        });

        System.out.println("compute:" + map.get(k1));

        map.computeIfPresent(k1, (k, v) -> {
            v.add(999);
            return v;
        });
        System.out.println("computeIfPresent:" + map.get(k1));

        map.computeIfAbsent("k2", (k) -> new ArrayList<>(128));
        System.out.println("computeIfAbsent:" + map.get("k2"));

    }

}
