class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int closestSum=0;
        int minDiff = Integer.MAX_VALUE;
      Arrays.sort(nums);
        int l = nums.length;
        for(int i=0;i<l-1;i++) {
            int j=i+1;
            int k=l-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
               // System.out.println(sum);
                int diff = Math.abs(sum-target);
                if(diff==0) {return sum;}
                if(diff<minDiff) {
                    minDiff=diff;
                    closestSum=sum;
                }
                if(sum>target) {k--;}
                else j++;
            }
        }
        return closestSum;
    }
}
