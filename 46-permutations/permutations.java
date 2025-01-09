class Solution {
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void solve(int start,List<List<Integer>>res,int[] nums){
        if(start==nums.length-1){
            List<Integer>curr=new ArrayList<>();
            for(int num:nums){
                curr.add(num);
            }
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<nums.length;i++){
           swap(nums,start,i);
           solve(start+1,res,nums);
           swap(nums,start,i);

        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        solve(0,res,nums);
        return res;

    }
}