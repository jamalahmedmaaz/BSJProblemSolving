package jamal.dataStuctureDesign;

import java.util.Deque;
import java.util.LinkedList;
public class MyCircularDeque {

    private final int capacity;
    Node head;
    Node tail;
    private int size;

    public MyCircularDeque(int capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(50);
        Deque dq = new LinkedList();
        dq.push(1);
        dq.push(2);

        System.out.println(dq.pop());
        myCircularDeque.insertFront(1);
        myCircularDeque.insertFront(2);
        myCircularDeque.insertFront(3);
        myCircularDeque.print();
        myCircularDeque.printBack();
        myCircularDeque.deleteFront();
        myCircularDeque.deleteLast();
        myCircularDeque.print();
        myCircularDeque.printBack();
        System.out.println();
    }

    private void printBack() {
        Node tmpTail = tail;
        while (tmpTail != null) {
            System.out.println(tmpTail.val);
            tmpTail = tmpTail.previous;
        }
        System.out.println("-----");
    }

    public void print() {
        Node tmpFirst = head;
        while (tmpFirst != null) {
            System.out.println(tmpFirst.val);
            tmpFirst = tmpFirst.next;
        }
        System.out.println("-----");
    }

    public boolean insertFront(int val) {
        if (capacity == size) {
            deleteLast();
        }
        final Node tmpHead = head;
        final Node newNode = new Node(null, val, tmpHead);
        head = newNode;

        if (tmpHead == null) {
            tail = newNode;
        } else {
            tmpHead.previous = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteLast() {
        if (tail == null) {
            return false;
        }
        final Node tmpTail = tail;
        final Node previous = tmpTail.previous;
        tmpTail.previous = null;
        tail = previous;
        if (previous == null) {
            head = null;
        } else {
            previous.next = null;
        }
        size--;
        return true;
    }

    public boolean deleteFront() {
        if (head == null) {
            return false;
        }
        final Node tmpFirst = head;
        final Node next = tmpFirst.next;
        tmpFirst.next = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.previous = null;
        }
        size--;
        return true;
    }

    public boolean insertLast(int val) {
        if (capacity == size) {
            deleteFront();
        }
        final Node tmpTail = tail;
        final Node newNode = new Node(tmpTail, val, null);
        tail = newNode;

        if (tmpTail == null) {
            head = newNode;
        } else {
            tmpTail.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (head != null) {
            return head.val;
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (tail != null) {
            return tail.val;
        }
        return -1;
    }

    class Node {
        public Node next;
        public Node previous;
        private int val;

        public Node(Node previous, int val, Node next) {
            this.val = val;
            this.previous = previous;
            this.next = next;
        }
    }
}
