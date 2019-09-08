package jamal.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {

    private int min;
    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }

        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key); // remove key from current count (since we will inc count)
        if (count == min && countToLRUKeys.get(count).size() == 0) {
            min++; // nothing in the current min bucket
        }

        putCount(key, count + 1);
        print();
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value); // update key's value
            get(key); // update key's count
            print();
            return;
        }

        if (keyToVal.size() >= capacity) {
            evict(countToLRUKeys.get(min).iterator().next()); // evict LRU from this min count bucket
        }

        min = 1;
        putCount(key, min); // adding new key and count
        keyToVal.put(key, value); // adding new key and value
        print();
    }

    private void evict(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
    }

    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, ignore -> new LinkedHashSet<>());
        countToLRUKeys.get(count).add(key);
    }

    private void print() {
        System.out.println("Start ");
        System.out.println(min);
        System.out.println("keyToVal: " + Arrays.toString(keyToVal.entrySet().toArray()));
        System.out.println("keyToCount: " + Arrays.toString(keyToCount.entrySet().toArray()));

        for (Map.Entry<Integer, LinkedHashSet<Integer>> instance : countToLRUKeys.entrySet()) {
            System.out.println("countToLRUKeys -> " + instance.getKey() + "  " + Arrays.toString(instance.getValue().toArray()));
        }
        System.out.println("End ");
        System.out.println();
    }

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(3, 30);
        lfuCache.put(5, 50);

        lfuCache.get(5);

        lfuCache.put(7, 70);
    }

}