package jamal.datastructure;

public class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.print();
    }

    private void addAtIndex(int index, int val) {
        Node node = new Node(val);
        if (index == 0) {
            addToHead(val);
        } else if (size > index) {
            int i = 0;
            Node tmpHead = head;
            Node previous = null;

            while (tmpHead != null) {
                if (index == i) {
                    break;
                }
                i++;
                previous = tmpHead;
                tmpHead = tmpHead.next;
            }
            node.next = tmpHead;
            previous.next = node;
            size++;
        } else {
            add(val);
        }
    }

    private void add(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;

        }
        ++size;
    }

    private void print() {
        System.out.println("-------");
        for (Node tmpHead = head; tmpHead != null; tmpHead = tmpHead.next) {
            System.out.println(tmpHead.val);
        }
        System.out.println("-------");
    }

    private void addToHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head = node;
        }
        ++size;
    }

    private void delete(int index) {
        if (index >= size) {
            return;
        } else if (index == 0) {
            deleteFromHead();
        } else {
            int i = 0;
            Node tmpHead = head;
            Node previous = null;

            while (tmpHead != null) {
                if (index == i) {
                    break;
                }
                i++;
                previous = tmpHead;
                tmpHead = tmpHead.next;
            }
            Node next = tmpHead.next;
            tmpHead.next = null;
            previous.next = next;
            size--;
        }
    }

    private void deleteFromHead() {
        if (head == null) {
            return;
        } else {
            head = head.next;
            --size;
        }
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
