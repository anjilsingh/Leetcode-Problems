class Solution {
    public int findShortestSubArray(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int degree = 0;
        List<Integer> deg_element = new ArrayList<>();
        /**get all the degree elements**/
        for (int element : nums){
            int count = map.getOrDefault(element, 0) + 1;
            if (count >= degree){
                if (count > degree)
                    deg_element.clear();
                deg_element.add(element);
            }
            degree = java.lang.Math.max(degree, count);
            map.put(element, count);
        }
        int min_size = nums.length;
        /**among all the degree elements, calculate min size**/
        for (int de : deg_element){
            int start = 0, end = 0;
            for (int i=0; i<nums.length; i++){
                if (nums[i]==de){
                    start = i;
                    break;
                }
            }
            for (int i=nums.length-1; i>=0; i--){
                if (nums[i]==de){
                    end = i;
                    break;
                }
            }
            min_size = java.lang.Math.min(min_size, end-start+1);
        }
        return min_size;
    }
}