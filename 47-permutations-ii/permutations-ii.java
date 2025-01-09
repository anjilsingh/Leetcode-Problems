class Solution {
     public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void solve(int start,int n,List<List<Integer>>res,int[] nums){
      if(start==n-1){
        List<Integer>curr=new ArrayList<>();
        for(int num:nums){
            curr.add(num);

        }
        res.add(new ArrayList<>(curr));
        return;
      }
      Set<Integer>set=new HashSet<>();
      for(int i=start;i<n;i++){
         if (set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
        swap(nums,start,i);
        solve(start+1,n,res,nums);
        swap(nums,start,i);
      }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        solve(0,n,res,nums);
        return res;
    }
}