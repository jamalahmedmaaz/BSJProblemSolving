package jamal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class Amazon {

    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        int[] i = new int[]{1, 2, 5, 10, 35, 89};
        int[] i1 = new int[]{20, 4, 8, 2};
        List<Integer> e = new ArrayList<>();
        for (int k : i) {
            e.add(k);
        }
        System.out.println(amazon.minimumTime(6, e));
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int minimumTime(int numOfSubFiles, List<Integer> files) {
        if (files == null || files.size() == 0) {
            return 0;
        }

        //Lets go by the approach where we add two elements.
        // But the base case (or the sub problem) is to pick the
        // least element currently existing in the list.

        //So MyPriorityQueue for the rescue.

        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.addAll(files);

        int min = 0;
        while (!pq.isEmpty()) {

            int ele1 = pq.poll();
            int ele2 = 0;
            if (!pq.isEmpty()) {
                ele2 = pq.poll(); //only when pq is not empty
                min = min + ele1 + ele2;
                pq.add(ele1 + ele2);
            }
        }

        return min;
    }
    // METHOD SIGNATURE ENDS
}