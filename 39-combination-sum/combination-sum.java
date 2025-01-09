class Solution {
    public static void solve(int[] candidates,int target,int sum,List<List<Integer>>ans,List<Integer>curr,int index,int n){
        if(target==sum){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum>target) {return;}
        for(int i=index;i<n;i++){
           
            curr.add(candidates[i]);
            solve(candidates,target,sum+candidates[i],ans,curr,i,n);
    
            curr.remove(curr.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        int n=candidates.length;
        solve(candidates,target,0,ans,new ArrayList<>(),0,n);
        return ans;
    }
}