package jamal.google.onlineassesment;

import java.util.Deque;
import java.util.LinkedList;
public class WateringFlowers {
    public static void main(String[] args) {
        WateringFlowers wateringFlowers = new WateringFlowers();
        System.out.println(wateringFlowers.water(new int[]{2, 4, 0, 1, 2}, 5, 7));
        System.out.println(wateringFlowers.water(new int[]{2, 4, 0, 1, 2}, 5, 7));
        System.out.println(wateringFlowers.water(new int[]{0}, 5, 7));
    }

    private int water(int[] flowers, int capacity1, int capacity2) {
        Deque<Integer> dq = new LinkedList<>();
        for (int flower : flowers) {
            dq.add(flower);
        }
        int count = 0;
        int water1 = 0;
        int water2 = 0;
        while (!dq.isEmpty()) {
            if (dq.size() == 1) {
                int lastOne = dq.poll();
                if (lastOne > water1 + water2) {
                    count++;
                }
            } else {
                int first = dq.pollFirst();
                int second = dq.pollLast();
                if (first <= water1) {
                    water1 = water1 - first;
                } else {
                    water1 = capacity1;
                    water1 = water1 - first;
                    count++;
                }
                if (second <= water2) {
                    water2 = water2 - second;
                } else {
                    water2 = capacity2;
                    water2 = water2 - second;
                    count++;
                }

            }
        }
        return count;
    }
}
