package jamal;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(5, 5);
        map.put(10, 10);
        map.put(11, 11);
        for (int i : map.keySet()) {
            pq.add(i);
        }

        map.put(5, -1);
        pq.add(pq.poll());
        System.out.println(pq.poll());

        int count = 0;
        while (!pq.isEmpty()) {
            int cell = pq.poll();
            System.out.println(cell);
            // if (count == 2) {

            // }
            count++;
            pq.add(cell);
            if (count == 4) {
                break;
            }
        }
    }
}