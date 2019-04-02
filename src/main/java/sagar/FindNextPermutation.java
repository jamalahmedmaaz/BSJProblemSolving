class FindNextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot=0;
        int l = nums.length;
        for(int i=l-1;i>0;i--) {
            if(nums[i-1]<nums[i]) {
                pivot=i;
                int index = findLargestFromEnd(nums,i-1);
                int temp = nums[i-1];
                nums[i-1]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        Arrays.sort(nums,pivot,l);
        
    }
    private int findLargestFromEnd(int [] nums,int idx) {
        for(int i=nums.length-1;i>idx;i--) {
            if(nums[i]>nums[idx])
                return i;
        }
        return -1;
    }
}
