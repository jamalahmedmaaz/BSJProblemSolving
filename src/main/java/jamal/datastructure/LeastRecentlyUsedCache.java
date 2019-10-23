package jamal.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

    private final int capacity;
    private MyDoublyLinkedList myDoublyLinkedList;
    private Map<Integer, MyDoublyLinkedList.Node> nodeMap;

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        myDoublyLinkedList = new MyDoublyLinkedList();
    }

    public static void main(String[] args) {
        LeastRecentlyUsedCache leastRecentlyUsedCache = new LeastRecentlyUsedCache(4);

        leastRecentlyUsedCache.refer(1);
        leastRecentlyUsedCache.refer(2);
        leastRecentlyUsedCache.refer(3);
        leastRecentlyUsedCache.refer(4);
        leastRecentlyUsedCache.refer(1);
        leastRecentlyUsedCache.refer(2);
        leastRecentlyUsedCache.refer(5);
        leastRecentlyUsedCache.refer(1);
        leastRecentlyUsedCache.refer(2);
        leastRecentlyUsedCache.refer(3);
        leastRecentlyUsedCache.refer(4);
        leastRecentlyUsedCache.refer(5);

        leastRecentlyUsedCache.myDoublyLinkedList.print();

    }

    private void refer(int value) {
        if (nodeMap.containsKey(value)) {
            MyDoublyLinkedList.Node node = nodeMap.remove(value);
            myDoublyLinkedList.deleteNode(node);
        } else {
            if (myDoublyLinkedList.getSize() == capacity) {
                MyDoublyLinkedList.Node node = myDoublyLinkedList.removeLast();
                nodeMap.remove(node.getValue());
            }
        }

        MyDoublyLinkedList.Node node = myDoublyLinkedList.addFirst(value);
        nodeMap.put(value, node);
    }

}
