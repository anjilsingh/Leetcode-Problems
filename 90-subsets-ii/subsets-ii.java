class Solution {
    public void solve(List<List<Integer>>res,int[] nums,int start,int n,List<Integer>curr){
     //add the curr list
     res.add(new ArrayList<>(curr));
     for(int i=start;i<n;i++){
        if(i>start && nums[i]==nums[i-1]) continue;
         curr.add(nums[i]);
         solve(res,nums,i+1,n,curr);
         curr.remove(curr.size()-1);
     }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(res,nums,0,n,new ArrayList<>());
        return res;
    }
}