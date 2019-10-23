package jamal.heap;

public class MyMinHeap {
    int[] A;
    int size;

    public MyMinHeap(int size) {
        A = new int[size];
    }

    public static void main(String[] args) {
        MyMinHeap myMinHeap = new MyMinHeap(10);

        for (int i = 10; i > 0; i--) {
            myMinHeap.add(i);
        }

        while (myMinHeap.isNotEmpty()) {
            System.out.println(myMinHeap.poll());
        }

    }

    public void add(int value) {
        if (size == A.length) {
            return;
        }

        incrementHeapSize();
        A[size - 1] = value;

        shiftUpInsertedValue(size - 1);
    }

    private void shiftUpInsertedValue(int childIndex) {
        int parentIndex, tmpData;
        if (childIndex != 0) {
            parentIndex = parentIndex(childIndex);
            if (A[parentIndex] > A[childIndex]) {
                tmpData = A[parentIndex];
                A[parentIndex] = A[childIndex];
                A[childIndex] = tmpData;
                shiftUpInsertedValue(parentIndex);
            }
        }
    }

    public Integer poll() {
        Integer min = null;
        if (isNotEmpty()) {
            min = A[0];
            A[0] = A[size - 1];
            size--;
            if (isNotEmpty()) {
                shiftDownTheFirstElement(0);
            }
        }
        return min;
    }

    public Integer peek() {
        return isNotEmpty() ? A[0] : null;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void shiftDownTheFirstElement(int index) {
        int minIndex;
        int leftIndex = leftChildIndex(index);
        int rightIndex = rightChildIndex(index);

        //Return if left and right are above the size.
        if (rightIndex >= size) {
            if (leftIndex >= size) {
                return;
            } else {
                minIndex = leftIndex;
            }
        } else {
            minIndex = A[leftIndex] <= A[rightIndex] ? leftIndex : rightIndex;
        }

        if (A[index] > A[minIndex]) {
            int tmp = A[minIndex];
            A[minIndex] = A[index];
            A[index] = tmp;
            shiftDownTheFirstElement(minIndex);
        }

    }

    private void incrementHeapSize() {
        size++;
    }

    public int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    public int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    public int parentIndex(int index) {
        return (index - 1) / 2;
    }

}
