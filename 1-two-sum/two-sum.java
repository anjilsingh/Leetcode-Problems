class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int diff=target-nums[i];

            if(mp.containsKey(diff) && mp.get(diff)!=i){
                return new int[]{i,mp.get(diff)};
            }
        }
        return new int[]{-1,-1};
    }
}