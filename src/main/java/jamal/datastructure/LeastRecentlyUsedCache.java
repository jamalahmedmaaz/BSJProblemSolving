package jamal.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsedCache {

    private final int capacity;
    private DoublyLinkedList doublyLinkedList;
    private Map<Integer, DoublyLinkedList.Node> nodeMap;

    public LeastRecentlyUsedCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        doublyLinkedList = new DoublyLinkedList();
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

        leastRecentlyUsedCache.doublyLinkedList.print();

    }

    private void refer(int value) {
        if (nodeMap.containsKey(value)) {
            DoublyLinkedList.Node node = nodeMap.remove(value);
            doublyLinkedList.deleteNode(node);
        } else {
            if (doublyLinkedList.getSize() == capacity) {
                DoublyLinkedList.Node node = doublyLinkedList.removeLast();
                nodeMap.remove(node.getValue());
            }
        }

        DoublyLinkedList.Node node = doublyLinkedList.addFirst(value);
        nodeMap.put(value, node);
    }

}
