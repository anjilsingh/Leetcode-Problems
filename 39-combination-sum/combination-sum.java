class Solution {
    public void solve(int[] candidates,int start,int sum,int n,List<List<Integer>>ans,int target,List<Integer>curr){

      if(sum==target){
        ans.add(new ArrayList<>(curr));
        return;
      }

      if(sum>target){
        return;

      }

      for(int i=start;i<n;i++){
        curr.add(candidates[i]);
        solve(candidates,i,sum+candidates[i],n,ans,target,curr);
        curr.remove(curr.size()-1);
      }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=candidates.length;
        solve(candidates,0,0,n,ans,target,new ArrayList<>());
        return ans;
    }
}