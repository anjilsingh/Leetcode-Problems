class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n=nums.length;
         HashMap<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<n;i++){
         mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        
        for(int num:nums){
           if(mp.get(num)>1) return true;
        }
        return false;
    }
}