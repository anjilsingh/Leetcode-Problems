class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        if(len1>len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n=(len1+len2+1)/2;
        
        int start=0;
        int end=len1;
        while(start<=end){
            int mid1=(start+end)/2;
            int mid2=n-mid1;
            int l1=mid1>0?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=mid2>0?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=mid1<len1?nums1[mid1]:Integer.MAX_VALUE;
            int r2=mid2<len2?nums2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if((len1+len2)%2==0){
                    return ((double)Math.max(l1,l2)+(double)Math.min(r1,r2))/2;

                }
                else{
                    return (double)Math.max(l1,l2);
                }
            }
            else if(l1<=r2){
                start=mid1+1;
            }
            else{
                end=mid1-1;
            }
        }
        return -1;
    }
}