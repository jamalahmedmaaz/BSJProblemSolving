package jamal.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Permutation {

    private List<Integer> tmp = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Permutation permutation = new Permutation();
        permutation.permutate(A);
        int count = 1;
        for (List<Integer> list : permutation.getResult()) {
            Integer nums[] = Arrays.asList(list.toArray())
                    .toArray(new Integer[0]);
            System.out.println("Permutation no " + (count++) + " " + Arrays.toString(list.toArray()) + " Next Permutation --> "
                    + Arrays.toString(permutation.nextPermutation(nums)));
        }

    }

    private List<List<Integer>> getResult() {
        return result;
    }

    private void permutate(int[] A) {
        if (tmp.size() == A.length) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < A.length; i++) {
            if (tmp.contains(A[i])) {
                continue;
            }
            tmp.add(A[i]);
            permutate(A);
            tmp.remove(tmp.size() - 1);
        }
    }

    public Integer[] nextPermutation(Integer[] nums) {
        int decrementIndex = decIndex(nums);

        if (decrementIndex > 0) {
            int nextBiggerEleIndx = find(decrementIndex, nums);
            if (nextBiggerEleIndx != -1 && decrementIndex - 1 >= 0) {
                int tmp = nums[decrementIndex - 1];
                nums[decrementIndex - 1] = nums[nextBiggerEleIndx];
                nums[nextBiggerEleIndx] = tmp;
            }
        }
        // System.out.println(Arrays.toString(nums));
        reverse(decrementIndex, nums);
        return nums;
    }

    public int find(int start, Integer nums[]) {
        int nextBiggerIndex = -1;
        int nextValue = Integer.MAX_VALUE;
        int current = nums[start - 1];
        for (int i = start; i < nums.length; i++) {
            // System.out.println(current +"  " +nums[i]);
            if (current < nums[i] && nums[i] < nextValue) {
                // System.out.println(nums[i]);
                nextValue = nums[i];
                nextBiggerIndex = i;
            }
        }
        return nextBiggerIndex;
    }

    private void reverse(int start, Integer nums[]) {
        int end = nums.length - 1;
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public int decIndex(Integer[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }
}
