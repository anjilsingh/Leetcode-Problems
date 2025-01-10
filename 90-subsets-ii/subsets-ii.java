class Solution {
    public void solve(int start,int[] nums,List<List<Integer>>res,List<Integer>curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            solve(i+1,nums,res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>res=new ArrayList<>();
        solve(0,nums,res,new ArrayList<>());
        return res;
    }
}