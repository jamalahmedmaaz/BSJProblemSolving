package jamal;

import java.util.Arrays;
public class Ticket {
    int[] days;
    int[] year;
    int[] costs;
    int[] cover = new int[]{1, 7, 30};
    int max = 0;

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        System.out.println(ticket.mincostTickets(new int[]{1, 4, 6, 20}, new int[]{2, 7, 15}));
    }

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        year = new int[400];
        int min = Integer.MAX_VALUE;
        for (int element : days) {
            year[element] = 1;
            max = Math.max(max, element);
            min = Math.min(min, element);
        }
        System.out.println(Arrays.toString(year));
        this.costs = costs;
        int result = rec(min, 0);
        return result;
    }

    public int rec(int idx, int total) {
        // System.out.println(idx + " "+total);
        if (idx >= max) {
            return total;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            int element = costs[i];
            int daysCovered = cover[i];
            int tmp = idx + daysCovered;
            tmp = findNextValidDay(tmp);
            min = Math.min(min, rec(tmp, total + element));
        }
        return min;
    }

    public int findNextValidDay(int tmp) {
        for (int i = tmp; i <= max; i++) {
            if (year[i] == 1) {
                tmp = i;
                System.out.println("Next index " + tmp);
                return tmp;
            }
        }
        System.out.println("Next index  no  change" + tmp);
        return tmp;
    }
}
