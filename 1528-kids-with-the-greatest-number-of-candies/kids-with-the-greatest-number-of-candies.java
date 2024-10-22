class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
   
         //first find the maximum candy value in the array
        
        int max=candies[0];
        for(int cany:candies){
           if(cany>=max){
              max=cany;
           }
        }
        ArrayList<Boolean>ans=new ArrayList<>();
        
        for(int candy:candies){
          ans.add(candy+extraCandies>=max);
        }
        return ans;
    }
}