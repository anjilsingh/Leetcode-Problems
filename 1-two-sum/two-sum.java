class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int req=target-nums[i];

            if(mp.containsKey(req) && mp.get(req)!=i){
                return new int[]{i,mp.get(req)};
                
            }
            mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}