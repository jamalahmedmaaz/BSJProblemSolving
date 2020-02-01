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

class Solution {
    int[][] dp;
    int[] A;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumMoves(new int[]{1, 3, 1, 4, 5}));
    }

    public int minimumMoves(int[] A) {
        int n = A.length;
        dp = new int[n][n];
        this.A = A;
        return dfs(0, n - 1);
    }

    int dfs(int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        int min = dfs(i, j - 1) + 1;
        System.out.println(min + " " + i + " " + j);
        if (j > 0 && A[j] == A[j - 1]) {
            min = Math.min(min, dfs(i, j - 2) + 1);
        }
        for (int k = i; k < j - 1; ++k) {
            if (A[k] == A[j]) {
                min = Math.min(min, dfs(i, k - 1) + dfs(k + 1, j - 1));
            }
        }
        dp[i][j] = min;
        System.out.println(" ");
        return min;
    }
}
