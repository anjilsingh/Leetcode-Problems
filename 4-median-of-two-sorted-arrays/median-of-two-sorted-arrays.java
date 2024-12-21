class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int arr[]=new int[nums1.length+nums2.length];
         int ind=0;
        for(int num:nums1){
         arr[ind]=num;
            ind++;
        }
        for(int num:nums2){
          arr[ind]=num;
            ind++;
        }
        
        Arrays.sort(arr);
        int n=arr.length;
        //even
        if(n%2==0) return (double)(arr[n/2-1]+arr[n/2])/2;
        else return (double)arr[n/2];
    }
}