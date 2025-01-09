class Solution {
    public void solve(List<List<Integer>>res,int[] nums,int start,int n,List<Integer>curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<n;i++){
               curr.add(nums[i]);
               solve(res,nums,i+1,n,curr);
               curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(res,nums,0,n,new ArrayList<>());
        return res;
    }
}