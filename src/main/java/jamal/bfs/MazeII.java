package jamal.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
public class MazeII {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findShortestWay(new int[][]{{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4, 4}));
    }

    static class Solution {
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
            if (maze == null || maze.length == 0) {
                return "impossible";
            }

            if (ball == null || ball.length == 0) {
                return "impossible";
            }
            if (hole == null || hole.length == 0) {
                return "impossible";
            }
            int a = hole[0];
            int b = hole[1];

            int r = maze.length;
            int c = maze[0].length;
            List<String> list = new ArrayList();
            list.add("");
            PriorityQueue<int[]> q = new PriorityQueue<int[]>((q1, q2) -> list.get(q1[2]).compareTo(list.get(q2[2])));
            q.add(new int[]{ball[0], ball[1], list.size() - 1});
            int[][] costs = new int[r][c];
            for (int[] cost : costs) {
                Arrays.fill(cost, Integer.MAX_VALUE);
            }
            costs[ball[0]][ball[1]] = list.size() - 1;
            while (!q.isEmpty()) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                int index = cell[2];

                if (costs[x][y] == Integer.MAX_VALUE || list.get(costs[x][y]).compareTo(list.get(index)) > 0) {
                    continue;
                }
                costs[x][y] = index;
                for (int i = 0; i < directions.length; i++) {
                    int[] dir = directions[i];
                    int nx = x;
                    int ny = y;
                    String ncost = list.get(index);

                    //Usually we add elements in the queue, when we check if condition through this.
                    // here we do while loop to hit the wall or to a '1' obstacle.
                    // after hitting the wall or one, we reduce the ncost and nx and ny to add to queue.
                    while (nx >= 0 && ny >= 0 && nx < r && ny < c && maze[nx][ny] == 0) {
                        nx = nx + dir[0];
                        ny = ny + dir[1];
                        switch (i) {
                            case 0:
                                ncost = ncost + "u";
                                break;
                            case 1:
                                ncost = ncost + "r";
                                break;
                            case 2:
                                ncost = ncost + "d";
                                break;
                            case 3:
                                ncost = ncost + "l";
                                break;
                        }

                    }
                    ncost = ncost.substring(0, ncost.length() - 1);
                    nx = nx - dir[0];
                    ny = ny - dir[1];
                    list.set(index, ncost);
                    q.add(new int[]{nx, ny, index});
                }
            }
            return costs[a][b] == Integer.MAX_VALUE ? "impossible" : list.get(costs[a][b]);
        }
    }
}