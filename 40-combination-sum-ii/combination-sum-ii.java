class Solution {
    public void solve(int[] candidates,List<List<Integer>>res,List<Integer>curr,int start,int sum,int target){
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target){
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            curr.add(candidates[i]);
            solve(candidates,res,curr,i+1,sum+candidates[i],target);
            curr.remove(curr.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>res=new ArrayList<>();
        solve(candidates,res,new ArrayList<>(),0,0,target);
        return res;
    }
}