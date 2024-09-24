class Solution {
    public int missingNumber(int[] nums) {
        int ans=-1;  
        Map<Integer,Integer>mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
        }
        //now iterate through the numberrs from 1 to n and if it is not present in hashmap retturn that number
        for(int i=0;i<=nums.length;i++){
            
            if(!mp.containsKey(i)){
                ans=i;
            }
        }
        return ans;
    }
}