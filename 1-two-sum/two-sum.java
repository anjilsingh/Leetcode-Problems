class Solution {
    public int[] twoSum(int[] nums, int target) {
        
      //create a hashmap 
     //store the value and indices as key value pair then check if target-key present or not 
        
        int[] ans=new int[2];
        Map<Integer,Integer>mp=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int comp=target-nums[i];
            if(mp.containsKey(comp)){
                ans[0]=mp.get(comp);
                ans[1]=i;
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
}