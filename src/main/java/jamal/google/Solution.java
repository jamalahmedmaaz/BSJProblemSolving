package jamal.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        System.out.println(Arrays.toString(workers));
        double ans = 1e9;
        int sumq = 0;
        PQsort pQsort = new PQsort();
        PriorityQueue<Worker> pool = new PriorityQueue(pQsort);
        for (Worker worker : workers) {
            pool.offer(worker);
            sumq += worker.quality;
            System.out.println(Arrays.toString(pool.toArray()));
            if (pool.size() > K) {
                sumq -= pool.poll().quality;
            }
            if (pool.size() == K) {
                double ratio = sumq * worker.ratio();
                ans = Math.min(ans, ratio);
                System.out.println(ratio + "  " + ans);
            }
            System.out.println(Arrays.toString(pool.toArray()));
        }

        return ans;
    }

    static class PQsort implements Comparator<Worker> {

        public int compare(Worker one, Worker two) {
            return two.quality - one.quality;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mincostToHireWorkers(new int[]{10, 20, 5, 20}
                , new int[]{70, 50, 30, 140},
                2));
    }
}

class Worker implements Comparable<Worker> {
    public int quality, wage;

    public double ratio;

    public Worker(int q, int w) {
        quality = q;
        wage = w;
    }

    public double ratio() {
        ratio = (double) wage / quality;
        return ratio;
    }

    public int compareTo(Worker other) {
        return Double.compare(ratio(), other.ratio());
    }

    @Override
    public String toString() {
        return "[ quality=" + quality +
                ", wage=" + wage +
                ", ratio=" + ratio + "]";
    }
}
