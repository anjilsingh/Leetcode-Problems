class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        if(n==0){
            return;
        }
        k=k%n;
        if(k>n){
          return;
        }
        //create an empty array to store last k values
        int nums1[]=new int[k];
        int j=0;
        for(int i=n-k;i<n;i++){
           nums1[j]=nums[i];
           j++;
        }
        //right shift starting n-k elemnts
        for(int i=n-k-1;i>=0;i--){
             nums[i+k]=nums[i];
        }
       //put stores values in front of original array
        for(int i=0;i<k;i++){
            nums[i]=nums1[i];
        }
        
    }
}