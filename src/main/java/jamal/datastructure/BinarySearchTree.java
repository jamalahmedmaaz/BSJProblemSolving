package jamal.datastructure;

/**
 * The type Binary search tree.
 */
public class BinarySearchTree {

    private Node root;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(4);
        binarySearchTree.insert(1);
        binarySearchTree.insert(6);
        binarySearchTree.insert(9);
        binarySearchTree.insert(8);
        binarySearchTree.insert(10);

        binarySearchTree.preOrderTraversal();
        System.out.println();

        binarySearchTree.delete(5);
        binarySearchTree.preOrderTraversal();

        System.out.println();
    }

    /**
     * Insert.
     *
     * @param val the val
     */
    public void insert(int val) {

        if (root == null) {
            root = new Node(val);
        } else {

            Node previous = root;
            Node tmp = previous;

            while (tmp != null) {
                previous = tmp;

                if (tmp.val >= val)
                    tmp = tmp.left;
                else
                    tmp = tmp.right;
            }

            if (previous.val >= val) {
                previous.left = new Node(val);
            } else {
                previous.right = new Node(val);
            }
        }
    }

    public void delete(int val) {

        if (root == null) return;

        Node tmp = root;
        Node previous = null;

        while (tmp != null) {
            if (tmp.val == val) {
                break;
            }

            previous = tmp;
            if (tmp.val > val) tmp = tmp.left;
            else tmp = tmp.right;
        }

        //Found it
        if (tmp != null) {
            if (tmp.left == null && tmp.right == null) {
                if (previous.left != null && previous.left.val == val) {
                    previous.left = null;
                } else {
                    previous.right = null;
                }
            }

            //Single child
            else if (tmp.left == null || tmp.right == null) {
                if (tmp.left != null) {
                    tmp.val = tmp.left.val;
                    tmp.left = null;
                } else {
                    tmp.val = tmp.right.val;
                    tmp.right = null;
                }
            }
            // Parent with two children.
            else {
                //First find the left most element of the right side tree of the found element.

                Node leftMost = tmp.right;
                Node leftPrevious = null;

                while (leftMost.left != null) {
                    leftPrevious = leftMost;
                    leftMost = leftMost.left;
                }

                if (leftPrevious == null) {
                    tmp.val = leftMost.val;
                    tmp.right = null;
                } else {
                    tmp.val = leftMost.val;
                    leftPrevious.left = null;
                }

            }
        }


    }

    /**
     * Pre order traversal.
     */
    public void preOrderTraversal() {

        Node tmp = root;
        inOrder(tmp);

    }

    private void inOrder(Node root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);

    }


    /**
     * The type Node.
     */
    class Node {
        private Node left;
        private Node right;
        private int val;

        /**
         * Instantiates a new Node.
         *
         * @param val the val
         */
        public Node(int val) {
            this.val = val;
        }

        /**
         * Gets left.
         *
         * @return the left
         */
        public Node getLeft() {
            return left;
        }

        /**
         * Sets left.
         *
         * @param left the left
         */
        public void setLeft(Node left) {
            this.left = left;
        }

        /**
         * Gets right.
         *
         * @return the right
         */
        public Node getRight() {
            return right;
        }

        /**
         * Sets right.
         *
         * @param right the right
         */
        public void setRight(Node right) {
            this.right = right;
        }

        /**
         * Gets val.
         *
         * @return the val
         */
        public int getVal() {
            return val;
        }

        /**
         * Sets val.
         *
         * @param val the val
         */
        public void setVal(int val) {
            this.val = val;
        }
    }


}
