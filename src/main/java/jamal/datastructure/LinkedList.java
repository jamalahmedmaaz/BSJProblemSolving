package jamal.datastructure;

public class LinkedList {

    private Node root;

    public static void main(String[] args) {


        LinkedList linkedList = new LinkedList();

        for (int i = 1; i <= 10; i++) {
            linkedList.insert(i);
        }

        print(linkedList);

        linkedList.delete(10);
        print(linkedList);
        linkedList.delete(4);
        print(linkedList);
        linkedList.delete(1);
        print(linkedList);

        for (int i = 1; i <= 10; i++) {
            linkedList.delete(i);
            print(linkedList);
        }
    }

    private static void print(LinkedList linkedList) {
        Node tmp = linkedList.root;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    private void insert(int val) {
        if (root == null) root = new Node(val);
        else {
            Node tmp = root;

            while (tmp.next != null) {
                tmp = tmp.next;
            }

            tmp.next = new Node(val);
        }

    }

    private void delete(int val) {

        if (root == null) return;
        else {


            Node tmp = root;
            Node previous = null;

            while (tmp != null) {
                if (tmp.val == val) {
                    break;
                } else {
                    previous = tmp;
                    tmp = tmp.next;
                }
            }

            if (tmp == null) {
                return;
            }

            //Three cases.
            //Last element.

            if (tmp.next == null) {
                if (previous != null) {
                    previous.next = null;
                } else {
                    root = null;
                }
            } else if (tmp.next != null) {
                //Root node.
                if (previous == null || previous == tmp) {
                    tmp.val = tmp.next.val;
                    tmp.next = tmp.next.next;
                } //not root node
                else {
                    previous.next = previous.next.next;
                }
            } else {
                root = null;
            }


        }
    }


    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


}
