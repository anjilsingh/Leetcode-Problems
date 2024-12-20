class Solution {
    public int evalRPN(String[] tokens) {
      
        Stack<Integer>st=new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                  int sec=st.pop();
                  int first=st.pop();
                if(s.equals("+")){
                    st.push(first+sec);
                }
                else if(s.equals("-")){
                 st.push(first-sec);
                }
                else if(s.equals("*")){
                              st.push(first*sec);
                }
                else{
                      st.push(first/sec);
                }
            }
            else{
                  st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}