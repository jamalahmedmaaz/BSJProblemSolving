package jamal.bfs;

import java.util.*;
public class StandardBFS {
    public static void main(String[] args) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, 1});
        pq.add(new int[]{0, 0, 2});
        pq.add(new int[]{0, 0, 3});

        while (!pq.isEmpty()) {
            System.out.println(Arrays.toString(pq.poll()));
        }

        StandardBFS standardBFS = new StandardBFS();
        int[][] graph = new int[][]{{5, 4, 5}, {1, 2, 6}, {7, 4, 6}};
        int[][] graph1 = new int[][]{{2, 2, 1, 2, 2, 3}, {1, 2, 2, 2, 1, 2}};
        int[][] graph2 = new int[][]{{3, 4, 6, 3, 4}, {0, 2, 1, 1, 7}, {8, 8, 3, 2, 7}, {3, 2, 4, 9, 8}, {4, 1, 2, 0, 0}, {4, 6, 5, 4, 3}};

//        standardBFS.bfs(graph);
//        standardBFS.bfs(graph1);

        standardBFS.bfs(graph2);
    }

    private int bfs(int[][] graph) {

        boolean visited[][] = new boolean[graph.length][graph[0].length];

        List<Integer> path = new ArrayList<>();
        LinkedList<int[]> queue = new LinkedList();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        path.add(graph[0][0]);
        int m = graph.length;
        int n = graph[0].length;

        System.out.print("(0,0),");
        int min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {

            int[] vertices = queue.poll();
            int x = vertices[0];
            int y = vertices[1];

            min = Math.min(min, graph[x][y]);
            LinkedList<int[]> neighbours = addFourDirections(x, y, visited, graph);
            for (int[] neighbour : neighbours) {
                int ni = neighbour[0];
                int nj = neighbour[1];
                if (!visited[ni][nj]) {

                    System.out.print(" (" + ni + "," + nj + ") ,");
                    visited[ni][nj] = true;
                    queue.add(neighbour);
                    path.add(graph[x][y]);

                    if (ni == m - 1 && nj == n - 1) {
                        System.out.println(Arrays.toString(path.toArray()));
                        System.out.println("The min Value is " + min);
                        System.out.println(Arrays.deepToString(visited));
                        return min;
                    }
                }
            }
        }
        return -1;
    }

    private LinkedList<int[]> addFourDirections(int x, int y, boolean[][] visited, int[][] graph) {
        LinkedList<int[]> linkedList = new LinkedList<>();
        int m = graph.length;
        int n = graph[0].length;

        int max = Integer.MIN_VALUE;
        int i1 = 0;
        int j1 = 0;
        List<Neighbor> neighbors = new ArrayList<>();

        if (x + 1 >= 0 && x + 1 < m) {
            int neigbourvalue = graph[x + 1][y];
            i1 = x + 1;
            j1 = y;
            if (!visited[i1][j1]) {
                neighbors.add(new Neighbor(neigbourvalue, new int[]{i1, j1}));
            }
        }
        if (y + 1 >= 0 && y + 1 < n) {
//            linkedList.add(new int[]{x, y + 1});
            int neigbourvalue = graph[x][y + 1];
            i1 = x;
            j1 = y + 1;
            if (!visited[i1][j1]) {
                neighbors.add(new Neighbor(neigbourvalue, new int[]{i1, j1}));
            }

        }
        if (x - 1 >= 0 && x - 1 < m) {
//            linkedList.add(new int[]{x - 1, y});
            int neigbourvalue = graph[x - 1][y];
            i1 = x - 1;
            j1 = y;
            if (!visited[i1][j1]) {
                neighbors.add(new Neighbor(neigbourvalue, new int[]{i1, j1}));
            }

        }

        if (y - 1 >= 0 && y - 1 < n) {
//            linkedList.add(new int[]{x, y - 1});
            int neigbourvalue = graph[x][y - 1];
            i1 = x;
            j1 = y - 1;
            if (!visited[i1][j1]) {
                neighbors.add(new Neighbor(neigbourvalue, new int[]{i1, j1}));
            }

        }

        Collections.sort(neighbors, Collections.reverseOrder());

        int lastSeen = -1;
        for (Neighbor neighbor : neighbors) {
            if (lastSeen == -1) {
                lastSeen = neighbor.value;
                linkedList.add(neighbor.index);
            } else if (lastSeen == neighbor.value) {
                linkedList.add(neighbor.index);
            } else {
                break;

            }
        }

        return linkedList;
    }

    class Neighbor implements Comparable<Neighbor> {
        Integer value;
        int[] index;

        public Neighbor(int neigbourvalue, int[] ints) {
            this.value = neigbourvalue;
            this.index = ints;
        }

        @Override
        public int compareTo(Neighbor neighbor) {
            return value.compareTo(neighbor.value);
        }
    }

}
