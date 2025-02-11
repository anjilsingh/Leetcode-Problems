class Solution {
    public void solve(int[] nums,int start,int n,List<List<Integer>>ans,List<Integer>curr){
 
        ans.add(new ArrayList<>(curr));
    
     for(int i=start;i<n;i++){
        if(i>start && nums[i]==nums[i-1]) continue;
        curr.add(nums[i]);
        solve(nums,i+1,n,ans,curr);
        curr.remove(curr.size()-1);
     }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        solve(nums,0,n,ans,new ArrayList<>());
        return ans;
    }
}