package jamal.heap;

import java.util.Arrays;

public class MinHeap {

    private int[] heap = null;
    private int size = 0;

    public MinHeap(int size) {
        heap = new int[size];
        // +1 because zero indexed.
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(19);

        minHeap.offer(10);
        minHeap.offer(20);
        minHeap.offer(30);
        minHeap.offer(40);
        minHeap.offer(50);
        minHeap.offer(60);
        minHeap.offer(70);
        minHeap.offer(80);
        minHeap.offer(90);
        minHeap.offer(100);
        for (int i = 1; i <= 9; i++)
            minHeap.offer(i);

        System.out.println(Arrays.toString(minHeap.heap));

        for (int i = 0; i < minHeap.size; i++) {
            System.out.print(minHeap.poll() + " ");
        }

    }

    /**
     * Insert or offer
     *
     * @param val
     * @return
     */
    public boolean offer(int val) {
        int currentIndex = size;
        size = currentIndex + 1;
        if (currentIndex == 0)
            heap[0] = val;
        else
            siftUp(currentIndex, val);
        return true;
    }

    private void siftUp(int currentIndex, int val) {
        siftUpComparable(currentIndex, val);
    }

    private void siftUpComparable(int currentIndex, int val) {
        while (currentIndex > 0) {
            int parent = (currentIndex - 1) >>> 1;
            int parentValue = heap[parent];
            if (parentValue <= val)
                break;
            heap[currentIndex] = parentValue;
            currentIndex = parent;
        }
        heap[currentIndex] = val;
    }

    /**
     * Insert or offer ends here.
     */

    /**
     * Extrac min or poll
     *
     * @return
     */

    public int poll() {
        if (size == 0)
            return -1;
        int s = --size;
        int result = heap[0];
        int x = heap[s];
        heap[s] = -1;
        if (s != 0)
            siftDown(0, x);
        return result;
    }

    private void siftDown(int index, int val) {
        siftDownUsingComparator(index, val);
    }

    private void siftDownUsingComparator(int index, int value) {
        int half = size >>> 1;
        while (index < half) {
            int childIndex = (index << 1) + 1;
            int childValue = heap[childIndex];
            int rightChildIndex = childIndex + 1;
            if (rightChildIndex < size && childValue < heap[rightChildIndex])
                childValue = heap[childIndex = rightChildIndex];
            if (value >= childValue)
                break;
            heap[index] = childValue;
            index = childIndex;
        }
        heap[index] = value;
    }


    public void offered(int value) {

        int index = size++;

        shiftingUp(index, value);
    }

    private void shiftingUp(int index, int value) {

        while (index > 0) {

            int parentIndex = index - 1 >>> 1;

            int parentValue = heap[parentIndex];

            if (parentValue < value) break;

            heap[index] = parentValue;

            index = parentIndex;
        }
        heap[index] = value;
    }

    public int polly() {
        int value = heap[0];

        int index = --size;
        int lastValue = heap[size];
        heap[size] = -1;

        if (index != 0)
            shiftingDown(0, lastValue);
        return value;
    }

    private void shiftingDown(int index, int lastValue) {
        int half = size >>> 1;

        while (index < half) {
            int childIndex = (index << 1) + 1;
            int childValue = heap[childIndex];

            int rightChildIndex = childIndex + 1;
            int rightChildValue = heap[rightChildIndex];

            if (rightChildIndex < size && rightChildValue > childValue) {
                heap[childIndex] = heap[childIndex = rightChildIndex];
            }

            if (lastValue >= childValue) {
                break;
            }

            index = childIndex;

        }

        heap[index] = lastValue;

    }


}
