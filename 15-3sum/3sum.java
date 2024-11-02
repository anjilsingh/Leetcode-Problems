class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;
            int l=i+1;
            int r=n-1;
            int target=-nums[i];
            while(l<r){
             if(nums[l]+nums[r]==target){
                 ans.add(Arrays.asList(nums[i],nums[l] , nums[r]));
                 while(l<r && nums[l]==nums[l+1])l++;
                 while(r>l && nums[r]==nums[r-1])r--;
                 l++;
                 r--;
             }
             else if(nums[l]+nums[r]<target){
                 l++;
             }
             else{
                 r--;
             }
            }
        }
        return ans;
    }
}