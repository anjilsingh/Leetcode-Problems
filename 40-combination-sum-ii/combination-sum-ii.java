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
        if(i>start && candidates[i]==candidates[i-1]) continue;
        curr.add(candidates[i]);
        solve(candidates,i+1,sum+candidates[i],n,ans,target,curr);
        curr.remove(curr.size()-1);
      }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=candidates.length;
        Arrays.sort(candidates);
        solve(candidates,0,0,n,ans,target,new ArrayList<>());
        return ans;
    }
}