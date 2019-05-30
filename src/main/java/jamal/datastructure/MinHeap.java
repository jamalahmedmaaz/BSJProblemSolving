package jamal.datastructure;

public class MinHeap {

    int minHeap[];
    int activeIndex = 0;

    public MinHeap() {
        minHeap = new int[100];
    }

    public static void main(String args[]) {
        int array[] = {3, 2, 1, 7, 8, 4, 10, 16, 12};
        System.out.print("Original Array : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("  " + array[i]);
        }
        MinHeap minHeap = new MinHeap();
        System.out.print("\nMin-Heap : ");
        minHeap.createHeap(array);
        minHeap.print();

        System.out.println();
        for (int i : array) {
            System.out.println(minHeap.extractMin());
        }

    }

    public void insert(int element) {
        minHeap[activeIndex] = element;
        bubbleUp(activeIndex);
        activeIndex++;
    }

    private void bubbleUp(int index) {
        int parentIndex = index / 2;
        int currentIndex = index;

        while (currentIndex > 0 && minHeap[parentIndex] > minHeap[currentIndex]) {

            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex / 2;
        }

    }

    private void swap(int currentIndex, int parentIndex) {
        int temp = minHeap[currentIndex];
        minHeap[currentIndex] = minHeap[parentIndex];
        minHeap[parentIndex] = temp;
    }

    private void print() {
        for (int i = 0; i < activeIndex; i++) {
            System.out.print(minHeap[i] + " ");
        }
    }

    private void createHeap(int[] array) {
        for (int element : array) {
            insert(element);
        }
    }

    public int extractMin() {
        int min = minHeap[0];
        minHeap[0] = minHeap[activeIndex];
        minHeap[activeIndex] = 0;

        sinkDown(1);

        activeIndex--;
        return min;
    }

    private void sinkDown(int i) {
        int smallest = i;
        int leftChildIdx = 2 * i;
        int rightChildIdx = 2 * i + 1;

        if (leftChildIdx < activeIndex && minHeap[smallest] > minHeap[leftChildIdx]) {
            smallest = leftChildIdx;
        }


        if (rightChildIdx < activeIndex && minHeap[smallest] > minHeap[rightChildIdx]) {
            smallest = rightChildIdx;
        }

        if (smallest != i) {
            swap(i, smallest);
            sinkDown(smallest);
        }

    }


}
