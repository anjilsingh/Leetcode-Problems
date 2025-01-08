class Solution {
    public void swap(int[] nums,int index,int i){
            int temp=nums[index];
            nums[index]=nums[i];
            nums[i]=temp;
        }
    public void solve(int[] nums,int index,int n,List<List<Integer>>res){
        //base case
        if(index==n-1){
            List<Integer>cur=new ArrayList<>();
            for(int num:nums){
                cur.add(num);
            }
            res.add(new ArrayList<>(cur));
            return;
        }
        //swap and call for next
        for(int i=index;i<n;i++){
            swap(nums,index,i);
            solve(nums,index+1,n,res);
            swap(nums,index,i);
        }

        
    }
    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>>res=new ArrayList<>();
      int n=nums.length;
      solve(nums,0,n,res);
      return res;
    }
}