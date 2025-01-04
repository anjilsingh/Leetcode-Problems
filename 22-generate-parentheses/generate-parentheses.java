class Solution {
    public static void gP(List<String>res,StringBuilder sb,int openN,int closedN,int n){
        if(openN==n && closedN==n){
            res.add(sb.toString());
            return;
        }
        if(openN<n){
            sb.append('(');
            gP(res,sb,openN+1,closedN,n);
           sb.deleteCharAt(sb.length() - 1);
        }
        if(closedN<openN){
            sb.append(')');
            gP(res,sb,openN,closedN+1,n);
           sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        gP(res,sb,0,0,n);
        return res;
    }
}