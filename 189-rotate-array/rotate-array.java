class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        
        //reverse the last k elements
         int l=n-k;
         int r=n-1;
         while(l<r){
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
             l++;
             r--;
         }
        
         int  x=0;
         int  y=n-k-1;
         while(x<y){
             int temp=nums[x];
             nums[x]=nums[y];
             nums[y]=temp;
             x++;
             y--;
         }
         int a=0;
         int b=n-1;
        while(a<b){
           int temp=nums[a];
            nums[a]=nums[b];
            nums[b]=temp;
            a++;
            b--;
                
        }
        
             
        
        
    }
}