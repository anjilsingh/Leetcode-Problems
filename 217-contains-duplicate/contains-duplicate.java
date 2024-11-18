class Solution {
    public boolean containsDuplicate(int[] nums) {
        //third method using hashset
        HashSet<Integer>seen=new HashSet<>();
        for(int num:nums){
            if(seen.contains(num)) return true;
            seen.add(num);

        }
        return false;
    }
}