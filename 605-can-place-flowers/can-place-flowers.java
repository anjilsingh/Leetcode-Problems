class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
         if(len>0 && n==0){
             return true;
         }
        // Special case when the flowerbed has only one plot
        if (len == 1) {
            // If flowerbed has a flower (1) or if n > 1, we cannot plant the required flowers
            
         
         if (flowerbed[0] == 1 || n > 1) {
                return false;
            }
            // Otherwise, if the plot is empty (0) and we need 1 flower, we can plant it
            return n == 0 || n == 1;
        }
        
        for (int i = 0; i < len; i++) {
            // Handle first element separately
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            // Handle last element separately
            else if (i == len - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            // Handle middle elements
            else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            // If we've planted all required flowers, we can return true early
            if (n == 0) {
                return true;
            }
        }
        
        return n == 0; // If we still need flowers to be planted, return false
    }
}
