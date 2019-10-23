package jamal.datastructure;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class UnionFind {

    int[] unionFind = new int[1000];


    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();

        Arrays.fill(unionFind.unionFind, -1);

        int[][] edges = new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {5, 6}, {5, 8}, {6, 7}, {6, 9}, {9, 1}};

        for (int[] edge : edges) {
            System.out.println(unionFind.unionFind(edge[0], edge[1]));
        }

    }

    private boolean unionFind(int a, int b) {
        int parenta = findParent(a);
        int parentb = findParent(b);
        if (parenta == parentb) {
            return true;
        } else {
            union(a, b, parenta, parentb);
        }
        return false;
    }

    private void union(int a, int b, int parenta, int parentb) {
        if (Math.abs(unionFind[parenta]) >= Math.abs(unionFind[parentb])) {
            unionFind[b] = parenta;
            unionFind[parenta]--;
        } else {
            unionFind[a] = parentb;
            unionFind[parentb]--;
        }
    }


    private int findParent(int element) {
        if (unionFind[element] < 0) {
            return element;
        }
        return findParent(unionFind[element]);
    }

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(intervals.length, Comparator.comparingInt(a -> a));
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));

        //Add End time of the sorted start time 2d array.
        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {

            int newStart = intervals[i][0];
            if (newStart >= pq.peek()) {
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        return pq.size();
    }

}
