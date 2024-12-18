class Solution {
    public boolean isPalindrome(String s) {
        //lets do it by using two ;pointer
        
        int l=0;
        int r=s.length()-1;
        
        while(l<r){
            char leftChar=Character.toLowerCase(s.charAt(l));
            char rightChar=Character.toLowerCase(s.charAt(r));
            
            if(Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                 if(leftChar!=rightChar) return false;
                 l++;
                r--;
            }
            else if(Character.isLetterOrDigit(leftChar)){
              r--;
            }
            else{
                l++;
            }
        }
        
        return true;
    }
}