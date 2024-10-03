class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>>ans=new ArrayList<>();
      Arrays.sort(nums);
      int n=nums.length;
     for(int i=0;i<n-2;i++){
        if(i>0 && nums[i]==nums[i-1]) continue;
         HashMap<Integer,Integer>mp=new HashMap<>();
         int x=-nums[i];
         
         for(int j=i+1;j<n;j++){
             int tar=x-nums[j];
             if(mp.containsKey(tar)){
                ans.add(Arrays.asList(nums[i],nums[j],tar));
                 while(j+1<n && nums[j]==nums[j+1]){
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