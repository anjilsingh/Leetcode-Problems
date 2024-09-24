class Solution {
    public int missingNumber(int[] nums) {
        //first method tc,sc-O(N) using hashmap
//         int ans=-1;  
//         Map<Integer,Integer>mp=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             mp.put(nums[i],i);
//         }
//         //now iterate through the numberrs from 1 to n and if it is not present in hashmap retturn that number
//         for(int i=0;i<=nums.length;i++){
            
//             if(!mp.containsKey(i)){
//                 ans=i;
//             }
//         }
//         return ans;
        
        //second method 
        //in second mehtod we can take the sum of given string ans the sum of first n natural no and subtract those by this we can find the missing number 
        int arrSum=0;
        for(int i=0;i<nums.length;i++){
            arrSum+=nums[i];
        }
        int orgSum=(nums.length)*(nums.length+1)/2;
        
        return orgSum-arrSum;
    }
}