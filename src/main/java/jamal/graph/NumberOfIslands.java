package jamal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        numberOfIslands.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {
                '1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}});
    }

    int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (Objects.equals(grid[i][j], '1')) {
                    Queue<int[]> queue = new LinkedList();
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        System.out.println(Arrays.deepToString(queue.toArray()));
                        int[] cell = queue.poll();
                        int x = cell[0];
                        int y = cell[1];
                        // System.out.println(Arrays.toString(cell));
                        grid[x][y] = '2';
                        // visited[x][y] = true;
                        // System.out.println(Arrays.deepToString(grid));
                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            while (nx < 0 || ny < 0 || nx >= r || ny >= c || !Objects.equals(grid[nx][ny], '1')) {
                                continue;
                            }
                            System.out.println(Arrays.toString(dir));
                            if (Objects.equals(grid[nx][ny], '1') || grid[nx][ny] == '1') {
                                queue.add(new int[]{nx, ny});
                            }

                        }
                        System.out.println(Arrays.deepToString(grid));
                    }
                    count++;
                }
            }
        }

        return count;
    }
}