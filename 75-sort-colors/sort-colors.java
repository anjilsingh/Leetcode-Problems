class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int left=0;
        int mid=0;
        int high=n-1;
        while(mid<=high){
           if(nums[mid]==0){
               swap(nums,mid,left);
               left++;
               mid++;
           }
          else if(nums[mid]==2){
               swap(nums,mid,high);
              
               high--;
           }
          else{
              mid++;
            }
        }
        
    }
    
    public static void swap(int[] arr, int a,int b){
           int temp=arr[a];
           arr[a]=arr[b];
           arr[b]=temp;
    }
}