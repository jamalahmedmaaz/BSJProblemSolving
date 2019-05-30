package jamal.datastructure;

/**
 * The type My hash map.
 */
public class MyHashMap {

    private Node[] array = new Node[10];

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 2);
        myHashMap.put(1, 3);
        myHashMap.put(1, 5);
        myHashMap.put(1, 6);


        myHashMap.put(2, 2);
        myHashMap.put(4, 3);
        myHashMap.put(123, 5);
        myHashMap.put(45, 6);


        System.out.println(myHashMap.get(1));
        myHashMap.remove(1, 2);
        myHashMap.remove(1, 5);

        System.out.println(myHashMap.get(1));
    }

    /**
     * Get int.
     *
     * @param key the key
     * @return the int
     */
    public int get(int key) {
        int index = key % array.length;

        Node node = array[index];
        if (node == null) {
            return -1;
        } else {
            while (node != null) {
                if (node.getKey() == key)
                    return node.getValue();
                node = node.next;
            }
        }

        return -1;

    }

    private void put(int key, int value) {

        int index = key % array.length;

        if (array[index] != null) {
            Node node = array[index];

            while (node != null) {
                if (node.getKey() == key && node.getValue() == value) {
                    return;
                }
                node = node.next;
            }
            Node newNode = new Node(key, value, array[index]);
            array[index].previous = newNode;
            array[index] = newNode;
            return;
        }

        array[index] = new Node(key, value, array[index]);
    }

    private void remove(int key) {
        int index = key % array.length;

        if (array[index] != null)
            array[index] = null;

    }

    private void remove(int key, int value) {
        int index = key % array.length;

        if (array[index] != null) {

            Node node = array[index];

            while (node != null) {

                if (node.getKey() == key && node.getValue() == value) {

                    if (node.previous != null) {

                        Node previous = node.previous;
                        Node next = node.next;

                        previous.next = next;
                        if (next != null)
                            next.previous = previous;

                    } else {
                        array[index] = node.next;
                        node.next.previous = null;
                    }
                    return;
                }
                node = node.next;
            }
        }

    }


    /**
     * The type Node.
     */
    class Node {
        private int key;
        private int value;

        private Node next;
        private Node previous;

        /**
         * Instantiates a new Node.
         *
         * @param key   the key
         * @param value the value
         * @param node  the node
         */
        public Node(int key, int value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        /**
         * Gets previous.
         *
         * @return the previous
         */
        public Node getPrevious() {
            return previous;
        }

        /**
         * Sets previous.
         *
         * @param previous the previous
         */
        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        /**
         * Gets next.
         *
         * @return the next
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets next.
         *
         * @param next the next
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Gets key.
         *
         * @return the key
         */
        public int getKey() {
            return key;
        }

        /**
         * Sets key.
         *
         * @param key the key
         */
        public void setKey(int key) {
            this.key = key;
        }

        /**
         * Gets value.
         *
         * @return the value
         */
        public int getValue() {
            return value;
        }

        /**
         * Sets value.
         *
         * @param value the value
         */
        public void setValue(int value) {
            this.value = value;
        }
    }

}
