class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //create a list of list to store the results        
        List<List<Integer>>ans=new ArrayList<>();
        //sort the array to remove the potential duplication
        Arrays.sort(nums);
        //now iterate through one one element 
       for(int i=0;i<nums.length-2;i++){
             if(i>0 && nums[i]==nums[i-1]) continue;   //ignore duplicate values
             int target=-nums[i];
             HashMap<Integer,Integer>mp=new HashMap<>();
        for(int j=i+1;j<nums.length;j++){
             int com=target-nums[j];
             if(mp.containsKey(com)){
               ans.add(Arrays.asList(nums[i],nums[j],com));
               while(j+1<nums.length && nums[j]==nums[j+1]) j++;
            }
                mp.put(nums[j],j);
             
    }

        
        
             
}
        return ans;
        
    }
}