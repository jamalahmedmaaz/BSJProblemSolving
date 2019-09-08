package jamal.array;

import java.util.Arrays;

public class SquareOfASortedArray {
    public static void main(String[] args) {
        SquareOfASortedArray squareOfASortedArray = new SquareOfASortedArray();
        System.out.println(Arrays.toString(squareOfASortedArray.square(new int[]{-4, -1, 0, 3, 10})));
    }

    private int[] square(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i <= j) {
            int a = A[i] * A[i];
            int b = A[j] * A[j];
            if (a > b) {
                int tmp = A[j];
                A[j] = a;
                A[i] = tmp;
                j--;
            } else {
                A[j] = b;
                j--;
            }
        }
        return A;
    }
}
