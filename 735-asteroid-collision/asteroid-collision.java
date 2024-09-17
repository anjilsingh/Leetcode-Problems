import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            // Process current asteroid
            boolean isDestroyed = false;  // Flag to check if the asteroid is destroyed
            
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                // Collision occurs between a left-moving asteroid and a right-moving one
                int rightAsteroid = stack.peek();
                
                if (Math.abs(rightAsteroid) < Math.abs(asteroid)) {
                    // Right-moving asteroid is smaller, it explodes
                    stack.pop();
                } else if (Math.abs(rightAsteroid) == Math.abs(asteroid)) {
                    // Both are the same size, both explode
                    stack.pop();
                    isDestroyed = true;
                    break;
                } else {
                    // Right-moving asteroid is bigger, the current asteroid is destroyed
                    isDestroyed = true;
                    break;
                }
            }
            
            // If the current asteroid isn't destroyed, add it to the stack
            if (!isDestroyed) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array and return
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
}
