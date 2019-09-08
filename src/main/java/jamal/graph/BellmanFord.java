package jamal.graph;

import java.util.HashMap;
import java.util.Map;
public class BellmanFord {

    private Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
    private Map<Integer, Integer> distance = new HashMap<>();
    private int[] uf;

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.graph = buildGraph();
        bellmanFord.initializeParent();
        bellmanFord.initializeDistance();
        bellmanFord.relax();
        bellmanFord.printSingleSourceShortestPath();

        bellmanFord.findNegativeCycle();
    }

    private void findNegativeCycle() {
        //Do one more relaxation and if values changes then there is a negative cycle.
    }

    public void relax() {
        int vertices = graph.size();
        for (int i = 0; i <= (vertices - 1); i++) {
            applyBellmanFordFormula();
        }
    }

    public void applyBellmanFordFormula() {
        for (Map.Entry<Integer, Map<Integer, Integer>> instance : graph.entrySet()) {
            int u = instance.getKey();

            for (Map.Entry<Integer, Integer> edge : instance.getValue().entrySet()) {
                int v = edge.getKey();

                int distanceOfV = distance.get(v);
                int distanceOfU = distance.get(u);
                int edgeWeight = edge.getValue();

                if (distanceOfV > distanceOfU + edgeWeight) {
                    //Update distance of V
                    distance.remove(v);
                    distance.put(v, distanceOfU + edgeWeight);
                    uf[v] = u;
                }
            }
        }
    }

    public static Map<Integer, Map<Integer, Integer>> buildGraph() {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        graph.put(0, new HashMap<>());
        graph.put(1, new HashMap<>());
        graph.put(2, new HashMap<>());
        graph.put(3, new HashMap<>());
        graph.put(4, new HashMap<>());
        graph.put(5, new HashMap<>());

        graph.get(0).put(3, 6);
        graph.get(0).put(1, 4);
        graph.get(0).put(2, 5);

        graph.get(1).put(2, -3);

        graph.get(2).put(5, 4);

        graph.get(3).put(4, 2);

        graph.get(4).put(5, 2);

        graph.get(5).put(4, 1);

        return graph;
    }

    public void initializeDistance() {
        for (int i : graph.keySet()) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.remove(0);
        distance.put(0, 0);
    }

    public void initializeParent() {
        uf = new int[graph.size()];
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }
    }

    public void printSingleSourceShortestPath() {
        distance.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
