class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] output=new int[nums1.length+nums2.length];
        
        int i=0;
        int j=0;
        int index=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
             output[index]=nums1[i];
                i++;
            }
            else{
                 output[index]=nums2[j];
                j++;
            }
            index++;
        }
        while(i<nums1.length){
             output[index]=nums1[i];
            i++;
            index++;
        }
        while(j<nums2.length){
            output[index]=nums2[j];
            j++;
            index++;
        }
        int n=output.length;
        if(n%2==0){
            return (double)((double)output[n/2]+(double)output[n/2-1])/2;
        }
        else{
           return (double)output[n/2];
        }
    }
}