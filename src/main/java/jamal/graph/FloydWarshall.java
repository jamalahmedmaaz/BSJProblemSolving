package jamal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FloydWarshall {
    int[][] distance;

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {

        //Thinking........
        //Two approaches, one is Normal BFS we can use and other is
        // Try to see it as a graph and apply Dijktra (with small change of 9) or
        // Flyod Warshall.

        distance = new int[lot.size()][lot.get(0).size()];
        int[] location = prepareLotAndReturnLocationOfNine(lot);

        relax();

        return distance[location[0]][location[1]];
    }

    public void relax() {
        for (int k = 0; k < distance.length; k++) {
            for (int i = 0; i < distance.length; i++) {
                for (int j = 0; j < distance.length; j++) {
                    int distanceV = distance[i][j];
                    long weight = (long) distance[i][k] + (long) distance[k][j];
                    if (distanceV > weight) {
                        distance[i][j] = (int) weight;
                    }
                }
            }
        }
    }

    public int[] prepareLotAndReturnLocationOfNine(List<List<Integer>> lot) {
        int[] nine = new int[2];
        for (int i = 0; i < lot.size(); i++) {
            for (int j = 0; j < lot.get(i).size(); j++) {
                if (lot.get(i).get(j) == 9) {
                    nine[0] = i;
                    nine[1] = j;
                    lot.get(i).set(j, 1);
                } else if (lot.get(i).get(j) == 0) {
                    lot.get(i).set(j, Integer.MAX_VALUE);
                }
                distance[i][j] = lot.get(i).get(j);
            }
        }
        return nine;
    }

    public static void main(String[] args) {
        List<List<Integer>> lot = new ArrayList<>();
        lot.add(Arrays.asList(1, 0, 0));
        lot.add(Arrays.asList(1, 0, 0));
        lot.add(Arrays.asList(1, 9, 0));
        FloydWarshall floydWarshall = new FloydWarshall();

        floydWarshall.removeObstacle(3, 3, lot);
    }
}