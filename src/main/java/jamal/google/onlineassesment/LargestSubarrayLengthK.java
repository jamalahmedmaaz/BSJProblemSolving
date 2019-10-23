package jamal.google.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class LargestSubarrayLengthK {

    public static void main(String[] args) {
        LargestSubarrayLengthK largestSubarrayLengthK = new LargestSubarrayLengthK();
        System.out.println(Arrays.toString(largestSubarrayLengthK.findLargestSubarrayLengthK(new int[]{1, 4, 3, 2, 5}, 4)));
    }

    private int[] findLargestSubarrayLengthK(int[] A, int k) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < k; i++) {
            if (A[i] != 0) {
                current = current * 10 + A[i];
            }
        }
        max = Math.max(max, current);
        int modder = 1;
        for (int i = 0; i < k - 1; i++) {
            modder = modder * 10;
        }

        for (int i = k; i < A.length; i++) {
            current = current % modder;
            current = current * 10 + A[i];
            max = Math.max(max, current);
        }
        List<Integer> result = new ArrayList<>();
        while (max > 0) {
            int last = max % 10;
            result.add(0, last);
            max = max / 10;
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }
}
