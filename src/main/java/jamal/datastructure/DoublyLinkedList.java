package jamal.datastructure;

public class DoublyLinkedList {

    private Node head;
    private Node tail;

    private int size;

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);

        doublyLinkedList.delete(1);
        doublyLinkedList.delete(3);
        doublyLinkedList.delete(5);

        doublyLinkedList.print();
        System.out.println();
    }

    public Node addFirst(int value) {
        size++;
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            head.previous = node;
            node.next = head;
            head = node;
        }
        return node;
    }

    public Node removeLast() {
        if (size != 0) {
            --size;
            if (head == tail) {
                Node node = head;
                head = tail = null;
                return node;
            } else {
                Node node = tail;
                Node nodePrevious = node.previous;
                nodePrevious.next = null;
                node.previous = null;
                tail = nodePrevious;
                return node;
            }
        }
        return null;
    }

    public void deleteNode(Node node) {
        --size;
        if (head == node) {
            Node tmp = head.next;
            head.next = null;
            tmp.previous = null;
            head = tmp;
        } else if (tail == node) {
            Node tmp = tail.previous;
            tail.previous = null;
            tmp.next = null;
            tail = tmp;
        } else {
            Node nodePrevious = node.previous;
            Node nodeNext = node.next;
            nodePrevious.next = nodeNext;
            nodeNext.previous = nodePrevious;
        }
    }


    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void print() {
        Node tmp = head;

        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }

        System.out.println();

        Node tailTmp = tail;

        while (tailTmp != null) {
            System.out.print(tailTmp.value + " ");
            tailTmp = tailTmp.previous;
        }

    }

    public void delete(int value) {
        if (head == null) {
            return;
        } else {
            if (head.value == value) {
                Node node = head.next;
                head.next = null;
                node.previous = null;
                head = node;
            } else if (tail.value == value) {
                Node node = tail.previous;
                tail.previous = null;
                node.next = null;
                tail = node;
            } else {
                Node tmp = head;
                while (tmp != null) {
                    if (tmp.value == value) {
                        tmp.previous.next = tmp.next;
                        tmp.next.previous = tmp.previous;
                        tmp.next = null;
                        tmp.previous = null;
                        return;
                    }
                    tmp = tmp.next;
                }
            }

            size--;
        }
    }

    public Node add(int value) {
        size++;
        if (head == null) {
            Node node = new Node(value);
            head = node;
            tail = node;
            return node;
        } else {
            Node node = new Node(value);
            node.previous = tail;
            tail.next = node;
            tail = node;
            return node;
        }
    }


    public class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(int value) {
            this.value = value;
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
}
