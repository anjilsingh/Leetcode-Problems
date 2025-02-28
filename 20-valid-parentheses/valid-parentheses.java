class Solution {
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()) return false;

                if(ch==')' && st.peek()!='(' ||
                        ch=='}' && st.peek()!='{' ||
                        ch==']' && st.peek()!='['
                )
                {
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}