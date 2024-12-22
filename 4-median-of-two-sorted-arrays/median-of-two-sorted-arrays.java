class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] output=new int[nums1.length+nums2.length];
        
        int index=0;
        for(int num:nums1){
            output[index++]=num;
        }
        for(int num:nums2){
            output[index++]=num;
        }
        Arrays.sort(output);
        int n=output.length;
        if(n%2==0){
            return (double)((double)output[n/2]+(double)output[n/2-1])/2;
        }
        else{
           return (double)output[n/2];
        }
    }
}