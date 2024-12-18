class Solution {
    public boolean isPalindrome(String s) {
        //can do it by removing extra spaces and then creating it using a string bbbuilder
        // and then reverse it 
        
        
        StringBuilder sb=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c))
           sb.append(Character.toLowerCase(c));
        }
        
        return sb.toString().equals(sb.reverse().toString());
    }
}