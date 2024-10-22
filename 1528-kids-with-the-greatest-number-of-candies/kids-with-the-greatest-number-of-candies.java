class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean>ans=new ArrayList<>();
        boolean[] arr=new boolean[candies.length];
        int[] cpyArr=new int[candies.length];
        for(int i=0;i<cpyArr.length;i++){
           cpyArr[i]=candies[i];
        }
        Arrays.sort(cpyArr);
        int largest=cpyArr[cpyArr.length-1];
        
        for(int i=0;i<candies.length;i++){
           if(candies[i]+extraCandies>=largest){
                arr[i]=true;
           }
        }
     for(int i = 0; i < arr.length; i++) {
    ans.add(arr[i]);  // Adds the element arr[i] to the list 'ans'
}
        
        return ans;
    }
}