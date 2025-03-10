class Solution {
    public void solve(int start,int sum,int n,int target,int[] candidates,List<List<Integer>>ans,List<Integer>curr){
        if(sum==target){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target ||start>=n){
            return;
        }
        for(int i=start;i<n;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            solve(i+1,sum+candidates[i],n,target,candidates,ans,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);
        solve(0,0,n,target,candidates,ans,new ArrayList<>());
        return ans;
    }
}