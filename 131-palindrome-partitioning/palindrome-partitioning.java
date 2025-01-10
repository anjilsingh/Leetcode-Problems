class Solution {
    public boolean isPalin(String s){
        int left=0;
        int right=s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    public void solve(int start,List<List<String>>res,List<String>curr,String s){
        if(start==s.length()){
            res.add(new ArrayList<>(curr));
        }
        for(int i=start;i<s.length();i++){
            if(isPalin(s.substring(start,i+1))){
                curr.add(s.substring(start,i+1));
                solve(i+1,res,curr,s);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        solve(0,res,new ArrayList<>(),s);
        return res;
    }
}