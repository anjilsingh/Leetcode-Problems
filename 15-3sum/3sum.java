class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      
        //the idea behind this is , a+b+c=0 , so we get -a-b value and then search for c in the hashmap if it is present then we will add the result in the array List
        
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
     
        for(int i=0;i<nums.length-2;i++){
            int tar=-nums[i];
            HashMap<Integer,Integer>mp=new HashMap<>();
            if(i>0 && nums[i]==nums[i-1])continue;
            for(int j=i+1;j<nums.length;j++){
              int com=tar-nums[j];
              
                if(mp.containsKey(com)){
                       ans.add(Arrays.asList(nums[i], nums[j], com));
                      while(j<nums.length-1 && nums[j]==nums[j+1]){
                          j++;
                      } 
                }
                mp.put(nums[j],1);
            }
        }
        return ans;
    }
}