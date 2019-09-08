package jamal.array;

import java.util.Arrays;

public class FlippingAnImage {

    public static void main(String[] args) {
        FlippingAnImage flippingAnImage = new FlippingAnImage();
        int[][] A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flippingAnImage.flip(A)));
    }

    private int[][] flip(int[][] A) {
        int n = A.length;
        for (int[] row : A) {
            for (int i = 0; i * 2 < A.length; i++) {
                if (row[i] == row[n - i - 1]) {
                    row[i] = row[n - i - 1] ^= 1;
                }
            }
        }
        return A;
    }
}
