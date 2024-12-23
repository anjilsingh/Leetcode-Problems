class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0;
        int fast=0;
        while(true){
         fast=nums[nums[fast]];
         slow=nums[slow];
            if(fast==slow) break;
        }
        
        //slow
        slow=0;
        
        while(true){
            fast=nums[fast];
            slow=nums[slow];
            if(fast==slow){
             return slow;
                
            }
        }

    }
}