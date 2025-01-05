class Solution {
    public static void solve(int[] candidates,int target,int sum,List<List<Integer>>ans,List<Integer>curr,int index){
        if(target==sum){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target||index>=candidates.length) return;
        //one time include the curr ele 
        curr.add(candidates[index]);
        solve(candidates,target,sum+candidates[index],ans,curr,index);
        //but when we dont include it we need to move one index further
        curr.remove(curr.size()-1);
        solve(candidates,target,sum,ans,curr,index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        solve(candidates,target,0,ans,new ArrayList<>(),0);
        return ans;
    }
}