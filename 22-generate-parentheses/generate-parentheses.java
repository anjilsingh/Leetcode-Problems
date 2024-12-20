class Solution {
    
    public void backtrack(int openN,int closedN,int n, List<String>res,StringBuilder sb)    {

    if(openN==n && closedN==n){
       res.add(sb.toString());
       return;
    }
   //explore left side
        if(openN<n){
            sb.append('(');
            backtrack(openN+1,closedN,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        if(closedN<openN){
           sb.append(')');
            backtrack(openN,closedN+1,n,res,sb);
             sb.deleteCharAt(sb.length()-1);
        }
    
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        backtrack(0,0,n,res,sb);
        return res;
    }
}