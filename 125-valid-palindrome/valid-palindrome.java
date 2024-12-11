class Solution {
    public boolean isPalindrome(String s) {
        
        int low=0;
        int high=s.length()-1;
        while(low<=high){
            
            char lChar=Character.toLowerCase(s.charAt(low));
            char hChar=Character.toLowerCase(s.charAt(high));
            
            if(Character.isLetterOrDigit(lChar)&& Character.isLetterOrDigit(hChar)){
                if(lChar!=hChar){
                  return false;
                }
                low++;
                high--;
            }
            else if(Character.isLetterOrDigit(lChar)){
                high--;
            }
            else{
                low++;
            }
            
            
        }
        return true;
        
    }
}