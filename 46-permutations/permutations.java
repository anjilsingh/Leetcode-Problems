class Solution {
    public void solve(int n,List<List<Integer>>res,int[] nums,List<Integer>curr){
        if(curr.size()==n){
            res.add(new ArrayList<>(curr));
        }
        for(int i=0;i<n;i++){
           if(curr.contains(nums[i])) {
                continue;
           }
           curr.add(nums[i]);
           solve(n,res,nums,curr);
           curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(n,res,nums,new ArrayList<>());
        return res;
    }
}