class Solution {
    public void solve(int openN,int closedN,int n,List<String>res,StringBuilder sb){
        if(openN==n && closedN==n){
            res.add(sb.toString());
        
        }

        if(openN<n){
            sb.append('(');
            solve(openN+1,closedN,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closedN<openN){
            sb.append(')');
            solve(openN,closedN+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        solve(0,0,n,res,sb);
        return res;
    }
}