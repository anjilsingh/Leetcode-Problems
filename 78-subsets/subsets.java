class Solution {
    public void solve(int start,int n,int[]nums,List<List<Integer>>ans,List<Integer>curr){
        ans.add(new ArrayList<>(curr));
        for(int i=start;i<n;i++){
            curr.add(nums[i]);
            solve(i+1,n,nums,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        solve(0,n,nums,ans,new ArrayList<>());
        return ans;
    }
}