class Solution {
    public void backTrack(int left,int right,int n,List<String>res,StringBuilder sb){
           
        if(left==n && right==n){
            res.add(sb.toString());
        }
        
        if(left<n){
          sb.append('(');
          backTrack(left+1,right,n,res,sb);
          sb.deleteCharAt(sb.length()-1);
        }
        
        if(right<left){
            sb.append(')');
          backTrack(left,right+1,n,res,sb);
          sb.deleteCharAt(sb.length()-1);

        }
    
    
    }
    public List<String> generateParenthesis(int n) {
        List<String>res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
         backTrack(0,0,n,res,sb);
        return res;
            
    }
}