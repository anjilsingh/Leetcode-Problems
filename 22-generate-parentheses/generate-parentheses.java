class Solution {
    public void gen(int openN,int closedN,int n,List<String>res,StringBuilder sb){
        if(openN==n && closedN==n){
            res.add(sb.toString());
            return ;
        }
        if(openN<n){
            sb.append('(');
            gen(openN+1,closedN,n,res,sb);
         sb.deleteCharAt(sb.length()-1);
        }
        if(closedN<openN){
            sb.append(')');
            gen(openN,closedN+1,n,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        List<String>res=new ArrayList<>();
        gen(0,0,n,res,sb);
        return res;
    }
}