class Solution {
    public int findDuplicate(int[] nums) {
        int fast=0;
        int slow=0;
        while(true){
            fast=nums[nums[fast]];
            slow=nums[slow];
            if(fast==slow){
                break;
            }
        }

        slow=0;
        while(true){
            fast=nums[fast];
            slow=nums[slow];
            if(fast==slow) break;
        }
        return slow;
    }
}