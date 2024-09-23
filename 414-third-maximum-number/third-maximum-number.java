class Solution {
    public int thirdMax(int[] nums) {
        int max=-1;
      Set<Integer>set=new HashSet<>();
       for(int i=0;i<nums.length;i++) {
           set.add(nums[i]);
       } 
      int ans[]=new int[set.size()];
     int index=0;
        for(int it:set){
              ans[index++]=it;
        }
        Arrays.sort(ans);
        if(ans.length<3){
           max=ans[ans.length-1];
        } 
        else{
              max=ans[ans.length-3];
        }
    return max;
    }
}