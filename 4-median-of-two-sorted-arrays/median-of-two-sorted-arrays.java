class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //better way to not use sorting here 
        //just sort the array directly 
        //like we did in  merge sort
        //now  better way is to 
        //we have to just find ind1 and ind2 
        //these ind are nothing but n/2-1 and n/2
        
        int len1=nums1.length;
        int len2=nums2.length;
        int total=len1+len2;
        //ind1 will be total/2-1
        //and ind2 will be total/2
        int ind1=-1;
        int ind2=-1;
        int i=0;
        int j=0;
        int index=-1;
        int curr=0;
        while(i<len1 && j<len2){
           
            
             if(nums1[i]<=nums2[j]){
               curr=nums1[i];
               i++;
               
             }
            else{
                curr=nums2[j];
             j++;
            }
            index++;
           if(index==total/2-1)  ind1=curr;
           if(index==total/2)    ind2=curr;
        }
        
        while(i<len1){
             index++;
             curr=nums1[i];
             i++;
           if(index==total/2-1)  ind1=curr;
           if(index==total/2)    ind2=curr;
        }
        
         while(j<len2){
             index++;
             curr=nums2[j];
             j++;
            if(index==total/2-1)  ind1=curr;
           if(index==total/2)    ind2=curr;
             }
        
        if(total%2==0)  return (double)(ind1+ind2)/2;
        else return (double) ind2;
    }
}