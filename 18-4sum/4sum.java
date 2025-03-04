class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
       List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for(int j=0;j<n;j++)
        {
             if(j>0 && nums[j]==nums[j-1]) continue;
        for(int i=j+1;i<n;i++){
            if(i>j+1 && nums[i]==nums[i-1]) continue;

            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                long sum=(long) nums[left]+nums[right]+nums[i]+nums[j];
                if(sum==target){
                    ans.add(Arrays.asList(nums[j],nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
                else if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }

        }
        }
        return ans;
    }
}