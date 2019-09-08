package jamal.graph;

import javafx.util.Pair;

import java.util.*;

public class ShortestPathBinaryMatrix {

    Map<Integer, Map<Integer, Integer>> edges = new HashMap();
    Map<Integer, Integer> result = new HashMap(); // Shortest path between source 00, n-1,m-1
    Map<Integer, Integer> distanceMap = new HashMap();
    PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));

    public static void main(String[] args) {
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        shortestPathBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        prepareEdges(grid);

        pq.add(new Pair<>(0, 0));
        distanceMap.put(0, 0);
        result.put(0, null);

        for (int i : edges.keySet()) {
            if (i != 0) {
                pq.add(new Pair(i, Integer.MAX_VALUE));
                distanceMap.put(i, Integer.MAX_VALUE);
            }
        }
        // System.out.println(Arrays.toString(pq.toArray()));

        edges.forEach((K, V) -> {                 // mapofmaps entries
            V.forEach((X, Y) -> {                     // inner Hashmap enteries
                System.out.println(K + " " + X + " " + Y);       // print key and value of inner Hashmap
            });
        });

        while (!pq.isEmpty()) {
            Pair<Integer, Integer> current = pq.poll();
            System.out.println(" -- " + current);
            Map<Integer, Integer> neighbours = edges.get(current.getKey());
            if (neighbours != null) {
                for (Map.Entry<Integer, Integer> instance : neighbours.entrySet()) {
                    checkIfNeighbourExistsAndUpdate(current, instance);
                }
            }
        }

        distanceMap.forEach((X, Y) -> {                     // inner Hashmap enteries
            System.out.println(X + " " + Y);       // print key and value of inner Hashmap
        });

        int i = grid.length - 1;
        int j = grid[0].length - 1;
        int lastIndex = i * grid.length + j;

        if (distanceMap.containsKey(lastIndex)) {
            return distanceMap.get(lastIndex) + 1;
        }

        return -1;
    }

    private void checkIfNeighbourExistsAndUpdate(Pair<Integer, Integer> current, Map.Entry<Integer, Integer> instance) {
        List<Pair<Integer, Integer>> tmp = new ArrayList();
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.poll();
            int calValue = instance.getValue() + current.getValue();
            System.out.println(" abc " + calValue);
            if (pair.getKey() == instance.getKey() && pair.getValue() > calValue) {
                tmp.add(new Pair(pair.getKey(), calValue));
                distanceMap.remove(pair.getKey());
                distanceMap.put(pair.getKey(), calValue);
                result.remove(pair.getKey());
                result.put(pair.getKey(), current.getKey());
                System.out.println(pair.getKey() + "   ---  " + calValue);
            } else {
                tmp.add(pair);
            }
        }
        pq.addAll(tmp);
    }

    public void prepareEdges(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int current = i * grid.length + j;
                if (grid[i][j] == 0) {
                    edges.put(current, new HashMap<>());

                    //Find 8 sides if they are any zero connections.
                    if (i + 1 < grid.length && grid[i + 1][j] == 0) {
                        edges.get(current).put((i + 1) * grid.length + j, 1);
                    }

                    if (j + 1 < grid[i].length && grid[i][j + 1] == 0) {
                        edges.get(current).put(i * grid.length + (j + 1), 1);
                    }

                    if (i - 1 >= 0 && grid[i - 1][j] == 0) {
                        edges.get(current).put((i - 1) * grid.length + j, 1);
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == 0) {
                        edges.get(current).put(i * grid.length + (j - 1), 1);
                    }

                    if (i - 1 >= 0 && j - 1 >= 0 && grid[i - 1][j - 1] == 0) {
                        edges.get(current).put((i - 1) * grid.length + (j - 1), 1);
                    }

                    if (i - 1 >= 0 && j + 1 < grid[i].length && grid[i - 1][j + 1] == 0) {
                        edges.get(current).put((i - 1) * grid.length + (j + 1), 1);
                    }

                    if (i + 1 < grid.length && j - 1 >= 0 && grid[i + 1][j - 1] == 0) {
                        edges.get(current).put((i + 1) * grid.length + (j - 1), 1);
                    }

                    if (i + 1 < grid.length && j + 1 < grid[i].length && grid[i + 1][j + 1] == 0) {
                        edges.get(current).put((i + 1) * grid.length + (j + 1), 1);
                    }
                }
            }
        }
    }

}