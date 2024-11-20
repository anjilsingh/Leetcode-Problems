class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //if a+b+c=0 then c=-a-b
        //so wee can take one element and the apply a for loop from its further and 
        //check if -nums[i]-nums[j] is present or not 
        //like we have done in 2 sum...whether target-nums[i]
        //present or not
        
        //lets do it now 
        
        //this will help in removing duplicates
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            
            //remove duplicate for further
            if(i>0 && nums[i]==nums[i-1]) continue;
            
            HashMap<Integer,Integer>mp=new HashMap<>();
            
    for(int j=i+1;j<nums.length;j++){
              int target=-nums[i]-nums[j];
              if(mp.containsKey(target)){
               ans.add(Arrays.asList(nums[i],target,nums[j]));
               while(j+1<nums.length && nums[j+1]==nums[j]){
                 j++;
               }
              }
           else{
                mp.put(nums[j],j);
           }
    }

        }
        return ans;
    }
}