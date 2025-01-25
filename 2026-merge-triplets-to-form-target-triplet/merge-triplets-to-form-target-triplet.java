class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        //thats so easy 
        //we have to just see that if any element of any triplet is greater than the target then that is not poosible
        //else apart from this for all other we will just add all elements of a set and see if set is size is equal to triplet size that is 3

        Set<Integer>set=new HashSet<>();
        
        for(int[] t:triplets){
          
          if(t[0]>target[0]|| t[1]>target[1]||t[2]>target[2]){
            continue;
          }

          for(int i=0;i<t.length;i++){
            if(t[i]==target[i]){
                set.add(i);
            }
          }
        }
        return set.size()==3;
    }
}