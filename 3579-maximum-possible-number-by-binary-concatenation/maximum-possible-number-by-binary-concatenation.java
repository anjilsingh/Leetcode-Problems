class Solution {
    public int maxGoodNumber(int[] nums) {
        String[] binaries = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            binaries[i] = Integer.toBinaryString(nums[i]);
        }
        
        // Sort using a custom comparator that maximizes concatenation
        Arrays.sort(binaries, (a, b) -> (b + a).compareTo(a + b));
        
        StringBuilder fullBinary = new StringBuilder();
        for (String binary : binaries) {
            fullBinary.append(binary);
        }
        
        return Integer.parseInt(fullBinary.toString(), 2);
    }
}