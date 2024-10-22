class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // If no flowers need to be planted, return true
        if (n == 0) return true;
        
        int len = flowerbed.length;
        
        // Edge case: If flowerbed length is 1
        if (len == 1) {
            if (flowerbed[0] == 0 && n == 1) return true;
            else return false;
        }
        
        // Iterate through the flowerbed
        for (int i = 0; i < len; i++) {
            // Check if the current spot is empty and can plant a flower
            if (flowerbed[i] == 0) {
                // Check left and right neighbors based on position
                boolean leftEmpty = (i == 0 || flowerbed[i - 1] == 0);   // No left neighbor or left is empty
                boolean rightEmpty = (i == len - 1 || flowerbed[i + 1] == 0); // No right neighbor or right is empty
                
                // If both neighbors are empty, plant a flower here
                if (leftEmpty && rightEmpty) {
                    flowerbed[i] = 1;  // Plant a flower
                    n--;  // Reduce the count of flowers to plant
                    
                    // Early return if we've planted all flowers
                    if (n == 0) return true;
                }
            }
        }
        
        // If after checking all spots, there are still flowers left to plant, return false
        return n == 0;
    }
}
