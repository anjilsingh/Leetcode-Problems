class Solution {
    public void solve(int[] nums,int start, int n, List<List<Integer>>ans,List<Integer>curr){

        if(curr.size()==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            solve(nums,i+1,n,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        solve(nums,0,n,ans,new ArrayList<>());
        return ans;
    }
}