class Solution {
    public int[] twoSum(int[] nums, int target) {
       //second approach using hashmap
        int[] ans=new int[2];
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
             if(mp.containsKey(target-nums[i])){
                    ans[0]=i;
                    ans[1]=mp.get(target-nums[i]);
             }
             else{
                mp.put(nums[i],i);
             }
        }
        Arrays.sort(ans);
        return ans;
    }
}