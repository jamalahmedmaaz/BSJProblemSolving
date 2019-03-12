class FindMedianOfTwoSortedArraysOptimal {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m= nums2.length;
        if(n<m) {
            return findMedian(nums1,n,nums2,m);
        } else {
            return findMedian(nums2,m,nums1,n);
        }
    }
    double findMedian(int[] A,int n, int[] B,int m) {
        int start=0,end=n,i=0,j=0;
        double median=0;
        while(start<=end) {
            i=(start+end)/2;
            j=(n+m+1)/2-i;
            if(i<n && j>0 && A[i]<B[j-1]) {
                start+=1;
            } else if(i>0 && j<m && A[i-1]>B[j]) { 
                end-=1;
            }
            else {
                if(i==0) {
                    median = B[j-1];
                } else if(j==0) {
                    median = A[i-1];
                } else {
                    median = Math.max(A[i-1],B[j-1]);
                }
                break;
            }
        }
        if((n+m)%2==1) {
            return (double)median;
        } 
        if(i==n) return ((double)(median + B[j]))/2;
        if(j==m) return ((double)(median+A[i]))/2;
        return ((double)(median + Math.min(A[i],B[j])))/2;
    }
}
