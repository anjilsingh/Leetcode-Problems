class Solution {
    public boolean isPalin(String s){
    int left=0;
    int right=s.length()-1;
    while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            return false;
        }
        left++;
        right--;
    }
    return true;
    }
    public void solve(String s,List<List<String>>res,List<String>curr,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalin(s.substring(start,i+1))){
                curr.add(s.substring(start,i+1));
                solve(s,res,curr,i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        solve(s,res,new ArrayList<>(),0);
        return res;
    }
}