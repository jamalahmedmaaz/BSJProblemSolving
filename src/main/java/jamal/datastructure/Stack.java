package jamal.datastructure;

public class Stack {

    private int[] stack;
    private int insertionPointer = -1;

    public Stack(int capacity) {
        this.stack = new int[capacity];
    }

    public static void main(String[] args) {
        Stack stack = new Stack(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public int push(int value) {
        if (insertionPointer == stack.length - 1) {
            return -1;
        } else {
            stack[++insertionPointer] = value;
            return insertionPointer;
        }
    }

    public int pop() {
        if (insertionPointer > 0) {
            return stack[insertionPointer--];
        }
        return -1;
    }

    public int peek() {
        if (insertionPointer > 0) {
            return stack[insertionPointer];
        }
        return -1;
    }

}
