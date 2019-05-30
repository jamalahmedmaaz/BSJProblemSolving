package jamal.datastructure;

import java.util.HashMap;
import java.util.Map;

public class LeastRecentlyUsed {

    private DoublyLinkedList doublyLinkedList;
    private Map<Integer, Node> map;
    private int capacity;

    public LeastRecentlyUsed(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList();
    }

    public static void main(String[] args) {
        LeastRecentlyUsed leastRecentlyUsed = new LeastRecentlyUsed(10);

        leastRecentlyUsed.add(1, 1);
        leastRecentlyUsed.add(2, 2);
        leastRecentlyUsed.add(3, 3);
        leastRecentlyUsed.add(4, 4);
    }

    public void add(int key, int value) {

        if (map.containsKey(key)) {

        } else {

            if (capacity <= map.size()) {
                Node tail = doublyLinkedList.getTail();
                map.remove(tail.getKey());

                remove(tail);

            }
            Node node = doublyLinkedList.add(key, value);
            map.put(key, node);
            bringToHead(node);

        }
    }

    private void bringToHead(Node node) {

    }

    private void remove(Node tail) {

    }

    public int get(int key) {
        return 0;
    }

    public void delete(int key) {

    }
}

class DoublyLinkedList {

    private Node root;


    public Node add(int key, int value) {
        return null;
    }


    public void delete(int key, int value) {

    }

    public Node getTail() {
        return null;
    }
}


class Node {
    private int key;
    private int value;
    private Node next;
    private Node previous;


    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}