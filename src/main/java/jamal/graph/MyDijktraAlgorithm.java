package jamal.graph;

import javafx.util.Pair;

import java.util.*;
public class MyDijktraAlgorithm {

    Map<Integer, List<Pair<Integer, Integer>>> graph = new HashMap<>();
    PriorityQueue<Pair<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
    Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {

        MyDijktraAlgorithm dijktraAlgorithm = new MyDijktraAlgorithm();

        //int[][] graph = {{1, 2, 7}, {2, 3, 5}, {3, 5, 8}};

        dijktraAlgorithm.graph.put(0, new ArrayList<>(Arrays.asList(new Pair<>(1, 2), new Pair<>(10, 2))));
        dijktraAlgorithm.graph.put(1, new ArrayList<>(Arrays.asList(new Pair<>(11, 3), new Pair<>(2, 7))));
        dijktraAlgorithm.graph.put(2, new ArrayList<>(Arrays.asList(new Pair<>(12, 5))));
        dijktraAlgorithm.graph.put(10, new ArrayList<>(Arrays.asList(new Pair<>(11, 3), new Pair<>(20, 3))));
        dijktraAlgorithm.graph.put(11, new ArrayList<>(Arrays.asList(new Pair<>(21, 5), new Pair<>(12, 5))));
        dijktraAlgorithm.graph.put(12, new ArrayList<>(Arrays.asList(new Pair<>(22, 8))));
        dijktraAlgorithm.graph.put(20, new ArrayList<>(Arrays.asList(new Pair<>(21, 5))));
        dijktraAlgorithm.graph.put(21, new ArrayList<>(Arrays.asList(new Pair<>(22, 8))));

        dijktraAlgorithm.map.put(0, 1);

        dijktraAlgorithm.priorityQueue.add(new Pair<>(0, 1));
        dijktraAlgorithm.findShortestPath();
        dijktraAlgorithm.map.entrySet().stream().forEach(System.out::println);
        System.out.println();
    }

    private void findShortestPath() {
        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> minElement = priorityQueue.poll();
            List<Pair<Integer, Integer>> neighbors = graph.get(minElement.getKey());
            if (neighbors != null) {
                for (Pair<Integer, Integer> neighbor : neighbors) {
                    Pair<Integer, Integer> currentElement = new Pair(neighbor.getKey(), neighbor.getValue() + minElement.getValue());
                    Pair<Integer, Integer> tmp = checkIfCurrentElementExists(neighbor.getKey());
                    if (tmp != null && tmp.getValue() > neighbor.getValue() + minElement.getValue()) {
                        System.out.println();
                        removeCurrentElement(currentElement);
                        currentElement = new Pair<>(currentElement.getKey(), currentElement.getValue() + minElement.getValue());
                        priorityQueue.add(currentElement);
                        map.put(currentElement.getKey(), currentElement.getValue());
                    } else {
                        int key = neighbor.getKey();
                        int value = minElement.getValue() + neighbor.getValue();
                        priorityQueue.add(new Pair<>(key, value));
                        map.put(key, value);
                    }
                }
            }
            System.out.println(Arrays.toString(priorityQueue.toArray()));
            map.entrySet().stream().forEach(System.out::println);
        }

    }

    private Pair<Integer, Integer> checkIfCurrentElementExists(int currentElement) {
        for (Pair<Integer, Integer> i : priorityQueue) {
            if (currentElement == i.getKey()) {
                return i;
            }
        }
        return null;
    }

    private void removeCurrentElement(Pair<Integer, Integer> currentElement) {
        List<Pair<Integer, Integer>> tmp = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Pair<Integer, Integer> element = priorityQueue.poll();
            if (element.getKey() != currentElement.getKey()) {
                tmp.add(element);
            } else {
                break;
            }
        }
        priorityQueue.addAll(tmp);
    }

}

