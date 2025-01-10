class Solution {
    public void solve(int[] nums,List<List<Integer>>res,List<Integer>curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
        }
        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            solve(nums,res,curr);
            curr.remove(curr.size()-1);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        solve(nums,res,new ArrayList<>());
        return res;
    }
}