class Solution {
    public boolean isPalin(String s){
        int left=0;
        int right=s.length()-1;
        while(left<=right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void solve(String s,int index, int n, List<List<String>>res,List<String>curr){
        //base case
        if(index>=n){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index;i<n;i++){
            if(isPalin(s.substring(index,i+1))){
                curr.add(s.substring(index,i+1));
                solve(s,i+1,n,res,curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>>res=new ArrayList<>();
        int n=s.length();
        solve(s,0,n,res,new ArrayList<>());
        return res;
    }
}