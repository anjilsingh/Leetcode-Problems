class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer>set=new HashSet<>();
        int n=candyType.length/2;
        for(int it:candyType){
          set.add(it);
        }
        return Math.min(n,set.size());
    }
}