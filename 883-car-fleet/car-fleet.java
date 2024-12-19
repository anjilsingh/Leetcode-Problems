class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        // Create array to store position-time pairs
        double[][] cars = new double[n][2];
        
        // Store position and calculate time to reach target for each car
        for (int i = 0; i < n; i++) {
            cars[i] = new double[] {position[i], (double)(target - position[i]) / speed[i]};
        }
        
        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        double slowest = 0;
        int fleets = 0;
        
        // Process cars from right to left
        for (int i = 0; i < n; i++) {
            if (cars[i][1] > slowest) {
                slowest = cars[i][1];
                fleets++;
            }
        }
        
        return fleets;
    }
}