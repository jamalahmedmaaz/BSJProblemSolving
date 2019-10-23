package jamal.bfs;

import java.util.*;
public class MyPriorityQueue {
    public static void main(String[] args) {
        System.out.println("a".compareTo("b"));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, Integer.MAX_VALUE);
        map.put(6, 5000);
        map.put(1, 20);
        map.put(2, 10);
        map.put(3, 40);
        map.put(4, 40);
        map.put(5, 2000);
        TreeSet<Integer> pq = new TreeSet<>(Comparator.comparingInt(map::get));
        pq.add(6);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);

        while (!pq.isEmpty()) {
            Integer cell = pq.pollFirst();
            if (cell == 2) {
                pq.remove(1);
                map.put(1, 100000);
                pq.add(1);
            }
            System.out.println(cell);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((a, b) -> a.compareTo(b));
        priorityQueue.add("ul");
        priorityQueue.add("lul");
        while (!priorityQueue.isEmpty()) {
            System.out.println("Lexo order " + priorityQueue.poll());
        }

    }
}
