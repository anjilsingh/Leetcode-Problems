class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        if (k == 0)
            return (int) Arrays.stream(nums).distinct().count();

        Arrays.sort(nums);

        int distinctNums = 0;
        int targetNum = nums[0] - k;
        for (int i = 0; i < nums.length; i++) {
            // If it falls within the range, set nums[i] to it and increment it by 1
            if ((nums[i] - k) <= targetNum && targetNum <= (nums[i] + k)) {
                nums[i] = targetNum;
                targetNum++;
                distinctNums++;
            }
            // If it falls below the range, first update it to the lowest number in the range 
            else if (targetNum <= nums[i] - k) {
                targetNum = nums[i] - k;
                nums[i] = targetNum;
                targetNum++;
                distinctNums++;
            }
        }

        return distinctNums;
    }
}