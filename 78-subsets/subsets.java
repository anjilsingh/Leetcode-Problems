class Solution {

    public void solve(int[] nums,int start,int n,List<List<Integer>>res,List<Integer>curr){
        res.add(new ArrayList<>(curr));
        for(int i=start;i<n;i++){
            curr.add(nums[i]);
            solve(nums,i+1,n,res,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(nums,0,n,res,new ArrayList<>());
        return res;
    }
}