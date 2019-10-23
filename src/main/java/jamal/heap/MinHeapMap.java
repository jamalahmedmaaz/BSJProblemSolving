package jamal.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class MinHeapMap {
    int[] A;
    int size;
    Map<Integer, Integer> map = new HashMap();

    public MinHeapMap(int size) {
        A = new int[size];
    }

    public static void main(String[] args) {
        MinHeapMap minHeapMap = new MinHeapMap(10);
        for (int i = 10; i >= 0; i--) {
            minHeapMap.add(i);
        }
        System.out.println(minHeapMap.map);
        System.out.println(Arrays.toString(minHeapMap.A));

        System.out.println(minHeapMap.poll());
        System.out.println(minHeapMap.map);
        System.out.println(Arrays.toString(minHeapMap.A));

        int index = minHeapMap.getIndex(5);
        minHeapMap.setValue(index, -125);
        minHeapMap.heapify(index);

        System.out.println(Arrays.toString(minHeapMap.A));
        System.out.println(minHeapMap.poll());

    }

    public void add(int value) {
        if (size == A.length) {
            return;
        }

        incrementHeapSize();
        A[size - 1] = value;
        map.put(value, size - 1);
        shiftUpInsertedValue(size - 1);
    }

    private void shiftUpInsertedValue(int childIndex) {
        int parentIndex, tmpData;
        if (childIndex != 0) {
            parentIndex = parentIndex(childIndex);
            if (A[parentIndex] > A[childIndex]) {
                tmpData = A[parentIndex];

                A[parentIndex] = A[childIndex];
                map.put(A[parentIndex], parentIndex);

                A[childIndex] = tmpData;
                map.put(A[childIndex], childIndex);

                shiftUpInsertedValue(parentIndex);
            }
        }
    }

    public Integer poll() {
        Integer min = null;
        if (isNotEmpty()) {
            min = A[0];
            A[0] = A[size - 1];
            A[size - 1] = -1;
            size--;
            if (isNotEmpty()) {
                shiftDownTheFirstElement(0);
            }
        }
        map.remove(min);
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
            map.put(A[minIndex], minIndex);
            A[index] = tmp;
            map.put(A[index], index);
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

    public int getIndex(int value) {
        return map.get(value);
    }

    public void setValue(int index, int value) {
        A[index] = value;
    }

    public void heapify(int index) {
        int element = A[index];
        shiftDownTheFirstElement(index);

        int newIndex = map.get(element);
        shiftUpInsertedValue(newIndex);
    }

}