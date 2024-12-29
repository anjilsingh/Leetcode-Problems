class Solution {
    public boolean containsDuplicate(int[] nums) {
        //4 approach
        //2 for loop,sort,hashmap,set

       HashSet<Integer>set=new HashSet<>();
       for(int num:nums){
        if(set.contains(num)){
                return true;
        }
        set.add(num);
       }
       return false;
    }
}