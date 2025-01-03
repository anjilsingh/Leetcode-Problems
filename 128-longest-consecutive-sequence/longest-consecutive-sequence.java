class Solution {
    public int longestConsecutive(int[] nums) {
    //  int n=nums.length;
    //  int longest=1;
    //  for(int i=0;i<n;i++){
    //      int x=nums[i];
    //      int count=1;

    //     while(LinearSearch(nums,x+1)==true){
    //         count++;
    //         x=x+1;
    //     }
    //     longest=Math.max(longest,count);
    //  }
    //  if(nums.length==0){
    //      return 0;
    //  }
    //  else{
    //  return longest;
    //  }
    //  }

    //  private static boolean LinearSearch(int[] nums,int num ){
    //      int l=nums.length;
    //      for(int i=0;i<l;i++){
    //          if(nums[i]==num){
    //             return true; 
    //          }
    //      }
    //  return false;
    int n=nums.length;
    Arrays.sort(nums);
    int cc=0;
    int largest=1;
    int ls= Integer.MIN_VALUE;

    for(int i=0;i<n;i++){
        if(nums[i]-1==ls){
            cc++;
            ls=nums[i];
        }
        else if(nums[i]!=ls){
            cc=1;
            ls=nums[i];

        }
        largest=Math.max(largest,cc);
    }

    if(nums.length==0){
        return 0;
    }

    else{
    return largest;
    }
     }
}