package jamal.random;

import java.util.*;
public class RandomProbability {
    ArrayList<Integer> numbers;
    HashMap<Integer, Integer> probabilityMap;
    java.util.Random random = new java.util.Random();

    /**
     * Initialize your data structure here.
     */
    public RandomProbability() {
        numbers = new ArrayList<>();
        probabilityMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        boolean contain = probabilityMap.containsKey(val);
        if (contain) return false;
        probabilityMap.put(val, numbers.size());
        numbers.add(val);

        print();

        return true;
    }

    private void print() {
        System.out.println(Arrays.toString(numbers.toArray()));
        for (Map.Entry<Integer, Integer> iinstance :
                probabilityMap.entrySet()) {
            System.out.println(iinstance.getKey() + " " + iinstance.getValue());
        }
        System.out.println();
    }

    /**
     * Removes a value from the set. Returns true if the set contained
     * the specified element.
     */
    public boolean remove(int val) {
        boolean contain = probabilityMap.containsKey(val);
        if (!contain) return false;
        int indexLocation = probabilityMap.get(val);
        if (indexLocation < numbers.size() - 1) { // not the last one than
            // swap the
            // last one with this val
            int lastElement = numbers.get(numbers.size() - 1);
            numbers.set(indexLocation, lastElement);
            probabilityMap.put(lastElement, indexLocation);
        }
        probabilityMap.remove(val);
        numbers.remove(numbers.size() - 1);
        print();

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return numbers.get(random.nextInt(numbers.size()));
    }

    public static void main(String[] args) {
        RandomProbability randomProbability = new RandomProbability();
        randomProbability.insert(1);
        randomProbability.insert(2);
        randomProbability.insert(3);
        randomProbability.insert(4);

        randomProbability.remove(2);

        System.out.println(randomProbability.getRandom());
    }
}