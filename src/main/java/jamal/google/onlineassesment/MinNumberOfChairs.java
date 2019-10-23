package jamal.google.onlineassesment;

import java.util.*;
public class MinNumberOfChairs {
    public static void main(String[] args) {
        int[] S = new int[]{1, 2, 6, 5, 3};
        int[] E = new int[]{5, 5, 7, 6, 8};
        MinNumberOfChairs minNumberOfChairs = new MinNumberOfChairs();
        System.out.println(minNumberOfChairs.findMin(S, E));
    }

    private int findMin(int[] s, int[] e) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            list.add(new int[]{s[i], e[i]});
        }
        Collections.sort(list, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a));
        int[] first = list.get(0);
        pq.add(first[1]);
        for (int i = 1; i < list.size(); i++) {
            int[] current = list.get(i);
            int start = current[0];
            int end = current[1];
            if (start >= pq.peek()) {
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }
}
