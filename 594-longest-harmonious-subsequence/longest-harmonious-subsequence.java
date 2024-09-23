class Solution {
    public int findLHS(int[] nums) {
        int res=0;
    Map<Integer,Integer>mp=new HashMap();
    for(int num:nums){
           mp.put(num,mp.getOrDefault(num,0)+1);
    }
    for(int key:mp.keySet()){
             if(mp.containsKey(key+1)){
              res=Math.max(res,mp.get(key)+mp.get(key+1));
             }
    }
        return res;
    }
}