package jamal.datastructure;

import java.util.HashMap;

class Node {
    int key;
    int value;
    int frequency = 0; //Visits
    Node next; //nextElement
    Node prev; //previousElement
    NodeQueue nq;  //outer linked list element

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class NodeQueue {
    NodeQueue next; //next element
    NodeQueue prev;  //previous-element
    Node tail;  //tail node
    Node head;  //head node

    public NodeQueue(NodeQueue next, NodeQueue prev, Node tail, Node head) {
        this.next = next;
        this.prev = prev;
        this.tail = tail;
        this.head = head;
    }
}

class LFUCache {


    NodeQueue tail;  //the end of the list NodeQueue
    int capacity;  //Capacity
    HashMap<Integer, Node> map;  //storage key-value fit HashMap

    //Construction method
    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>(capacity);
    }


    private void oneStepUp(Node n) {
        n.frequency++; //Visits +1
        boolean singleNodeQ = false; //When true, there is only one Node element in this NodeQueue
        if (n.nq.head == n.nq.tail)
            singleNodeQ = true;
        if (n.nq.next != null) {
            if (n.nq.next.tail.frequency == n.frequency) {
                //The number of accesses to the right NodeQueue is the same as the current number of accesses of the Node.
                // This node is placed at the head of the right NodeQueue.
                removeNode(n); //Remove Node from the current NodeQueue
                //Insert Node into the head of the right NodeQueue
                n.prev = n.nq.next.head;
                n.nq.next.head.next = n;
                n.nq.next.head = n;
                n.nq = n.nq.next;
            } else if (n.nq.next.tail.frequency > n.frequency) {
                //If the number of accesses to the right NodeQueue is greater than the number of current accesses to the Node,
                // you need to insert a new NodeQueue between the two NodeQueues.
                if (!singleNodeQ) {
                    removeNode(n);
                    NodeQueue nnq = new NodeQueue(n.nq.next, n.nq, n, n);
                    n.nq.next.prev = nnq;
                    n.nq.next = nnq;
                    n.nq = nnq;
                }
                //If there is only one Node in the current NodeQueue, then no extra operations are needed.
            }
        } else {
            //The next == null of this NodeQueue indicates that the NodeQueue is already in the outer list header.
            // In this case, you need to insert a new NodeQueue into the outer list header.
            if (!singleNodeQ) {
                removeNode(n);
                NodeQueue nnq = new NodeQueue(null, n.nq, n, n);
                n.nq.next = nnq;
                n.nq = nnq;
            }
            // Similarly, if there is only one Node in the current NodeQueue, no extra operations are required.
        }
    }

    private Node removeNode(Node n) {
        //If there is only one Node in the NodeQueue, then remove the entire NodeQueue
        if (n.nq.head == n.nq.tail) {
            removeNQ(n.nq);
            return n;
        }
        if (n.prev != null)
            n.prev.next = n.next;
        if (n.next != null)
            n.next.prev = n.prev;
        if (n.nq.head == n)
            n.nq.head = n.prev;
        if (n.nq.tail == n)
            n.nq.tail = n.next;
        n.prev = null;
        n.next = null;
        return n;
    }

    private void removeNQ(NodeQueue nq) {
        if (nq.prev != null)
            nq.prev.next = nq.next;
        if (nq.next != null)
            nq.next.prev = nq.prev;
        if (tail == nq)
            tail = nq.next;
    }

    public int get(int key) {
        Node n = map.get(key);
        if (n == null)
            return -1;
        oneStepUp(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        Node cn = map.get(key);
        //If the key already exists, update the value and move the Node to the right.
        if (cn != null) {
            cn.value = value;
            oneStepUp(cn);
            return;
        }
        //Cache is full，Remove the tail Node of the inner linked list at the end of the outer link
        if (map.size() == capacity) {
            map.remove(removeNode(this.tail.tail).key);
        }
        //插入新的Node
        Node n = new Node(key, value);
        if (this.tail == null) {
            //tail Null to indicate that there are no elements in the cache at this time  ，Directly put Node Packaged to NodeQueue Join
            NodeQueue nq = new NodeQueue(null, null, n, n);
            this.tail = nq;
            n.nq = nq;
        } else if (this.tail.tail.frequency == 0) {
            //The number of visits to the tail elements of the outer list is 0，Then will Node  Add to the head of the element at the end of the outer list
            n.prev = this.tail.head;
            this.tail.head.next = n;
            n.nq = this.tail;
            this.tail.head = n;
        } else {
            //The number of visits to the tail elements of the outer list is not 0，Then instantiate a one that only contains this Node
            // NodeQueue，Add to the end of the outer chain
            NodeQueue nq = new NodeQueue(this.tail, null, n, n);
            this.tail.prev = nq;
            this.tail = nq;
            n.nq = nq;
        }
        //最后把key和Node存入HashMap中
        map.put(key, n);
    }
}