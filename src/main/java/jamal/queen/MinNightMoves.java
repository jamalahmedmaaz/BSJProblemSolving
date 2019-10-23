package jamal.queen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
public class MinNightMoves {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println("a".compareTo("aaa"));
        System.out.println("aaa".compareTo("a"));
        System.out.println(solution.minKnightMoves(2, 2));
    }

    static class Solution {
        int[][] directions = new int[][]{{-2, 1}, {-2, -1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, 2}, {1, -2}};

        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            Queue<int[]> q = new LinkedList();
            q.add(new int[]{0, 0, 0});
            Set<Integer> set = new HashSet();
            while (!q.isEmpty()) {
                int[] cell = q.poll();
                int x1 = cell[0];
                int y1 = cell[1];
                int total = cell[2];
                if (x1 == x && y1 == y) {
                    return total;
                }

                for (int[] dir : directions) {
                    int nx = Math.abs(x1 + dir[0]);
                    int ny = Math.abs(y1 + dir[1]);
                    if (x == nx && y == ny) {
                        return total + 1;
                    }

                    int cal = nx * 1000 + ny;
                    if (!set.contains(cal)) {
                        q.add(new int[]{nx, ny, total + 1});
                        set.add(cal);
                    }
                }
            }
            return -1;
        }
    }
}
