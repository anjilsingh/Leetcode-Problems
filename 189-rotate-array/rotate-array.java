class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
         k=k%n;
        
        //storing the last k elements
        int temp[]=new int[k];
        int j=0;
        for(int i=n-k;i<n;i++){
             temp[j++]=nums[i];
        }
        
        //Now right rotate starting n-k elements
        for(int i=n-1;i>=k;i--){
              nums[i]=nums[i-k];    
        }
        //now put last 3 ele at starting 
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
    }
}