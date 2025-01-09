class Solution {
    public void solve(int n,List<List<Integer>>res,int[] nums,List<Integer>curr,HashMap<Integer,Integer>mp){
        if(curr.size()==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(Map.Entry<Integer,Integer>entry:mp.entrySet()){
            int key=entry.getKey();
            int val=entry.getValue();
           if(val==0) {
                continue;
           }
           curr.add(key);
           mp.put(key,mp.get(key)-1);
           solve(n,res,nums,curr,mp);
           curr.remove(curr.size()-1);
           mp.put(key,mp.get(key)+1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>res=new ArrayList<>();
        int n=nums.length;
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        solve(n,res,nums,new ArrayList<>(),mp);
        return res;
    }
}