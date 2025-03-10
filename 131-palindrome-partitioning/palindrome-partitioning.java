class Solution {
    public boolean isPali(String str){
        int l=0;
        int r=str.length()-1;
        while(l<=r){
            if(str.charAt(l)!=str.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public void solve(int start,int n,String s,List<List<String>>res,List<String>curr){
        if(start==n){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<n;i++){
            if(isPali(s.substring(start,i+1))){
                curr.add(s.substring(start,i+1));
                solve(i+1,n,s,res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        int n=s.length();
        solve(0,n,s,res,new ArrayList<>());
        return res;
    }
}