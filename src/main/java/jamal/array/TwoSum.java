package jamal.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * <p>
     * Example:
     * <p>
     * Given nums = [2, 7, 11, 15], target = 9,
     * <p>
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     * @param args
     */
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.hashMapSolution(new int[]{
                2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.advancedHashMapSolution(new int[]{
                2, 7, 11, 15}, 9)));

    }

    public int[] hashMapSolution(int[] nums, int target) {
        HashMap<Integer, Integer> numbersVsIndices = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            numbersVsIndices.put(nums[i], i);
        }

        for (Map.Entry<Integer, Integer> instance : numbersVsIndices.entrySet()) {
            int remainingValue = target - instance.getKey();
            if (remainingValue < target && numbersVsIndices.containsKey(remainingValue)) {
                return new int[]{instance.getValue(), numbersVsIndices.get(remainingValue)};
            }
        }

        return null;
    }


    public int[] advancedHashMapSolution(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        /**
         * Point1: Dont populate the hashmap in advance, save space.
         *
         * Point2: Other lets iterate through the array and find if the number already exists, this will
         * avoid the problem with duplicates
         */

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
