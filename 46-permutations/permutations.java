class Solution {
    public void solve(int[] nums,List<List<Integer>>ans,int start,int n,List<Integer>curr) {
        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<n;i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            solve(nums,ans,i+1,n,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        solve(nums,ans,0,n,new ArrayList<>());
        return ans;
    }
}