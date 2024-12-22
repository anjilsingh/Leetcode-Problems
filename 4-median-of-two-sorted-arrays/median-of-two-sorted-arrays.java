class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        
        int i=0;
        int j=0;
        int index1=-1;
        int index2=-1;
        int index=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
               
                if(index==n/2-1) index1=nums1[i];
                if(index==n/2) index2=nums1[i];
                index++;
                i++;
            }
            else{
             
                if(index==n/2-1) index1=nums2[j];
                if(index==n/2) index2=nums2[j];
                 index++;
                j++;
            }
            
        }
        while(i<nums1.length){
      
               if(index==n/2-1) index1=nums1[i];
                if(index==n/2) index2=nums1[i];
                  index++;
            i++;
          
        }
        while(j<nums2.length){
             
               if(index==n/2-1) index1=nums2[j];
                if(index==n/2) index2=nums2[j];
             index++;
            j++;
        }
        
        if(n%2==0){
            return (double)(index1+index2)/2;
        }
        else{
           return (double)index2;
        }
    }
}