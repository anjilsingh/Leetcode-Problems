class Solution {
    public void solve(int start,int n,int[] num,List<List<Integer>>res,List<Integer>curr){
       res.add(new ArrayList<>(curr));
        for(int i=start;i<n;i++){
            curr.add(num[i]);
            solve(i+1,n,num,res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(0,n,nums,res,new ArrayList<>());
        return res;
    }
}