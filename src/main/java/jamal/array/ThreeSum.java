package jamal.array;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(-3 * -9);
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Set<MyList> indexes = new HashSet<>();
        Arrays.sort(nums);

        for (int start = 0; start < nums.length; start++) {

            int currentValue = nums[start];

            int i = start + 1;
            int j = nums.length - 1;

            while (i < j) {
                if (currentValue + nums[i] + nums[j] == 0) {
                    MyList list = new MyList();
                    list.add(currentValue);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    indexes.add(list);
                    i++;
                } else {
                    if (currentValue + nums[i] + nums[j] > 0) {
                        j--;
                    } else {
                        i++;
                    }

                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for (MyList myList : indexes) {
            result.add(myList.getList());
        }

        return result;
    }

    class MyList {

        List<Integer> list = new ArrayList<>();

        public void add(Integer i) {
            list.add(i);
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }

        public int hashCode() {
            return 0;
        }

        @Override
        public boolean equals(Object list2) {
            return this.getList().containsAll(((MyList) list2).getList());
        }


    }

}
