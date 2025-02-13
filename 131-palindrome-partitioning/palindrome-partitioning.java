class Solution {
    public boolean isPali(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public void solve(String s,List<List<String>>res,int start,int n,List<String>curr){
        if(start==n){
            res.add(new ArrayList<>(curr));
        }
        for(int i=start;i<n;i++){
            if(isPali(s.substring(start,i+1))){
                curr.add(s.substring(start,i+1));
                solve(s,res,i+1,n,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        int n=s.length();
        solve(s,res,0,n,new ArrayList<>());
        return res;
    }
}