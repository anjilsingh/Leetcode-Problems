class Solution {
    public void solve(int[] candidates,int target,List<List<Integer>>res,List<Integer>curr,int start,int sum){
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) return;
        for(int i=start;i<candidates.length;i++){
            curr.add(candidates[i]);
            solve(candidates,target,res,curr,i,sum+candidates[i]);
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        solve(candidates,target,res,new ArrayList<>(),0,0);
        return res;
    }
}