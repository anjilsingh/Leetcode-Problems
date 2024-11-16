class Solution {
    public boolean isPalindrome(String s) {
        int low=0;
        int high=s.length()-1;
        while(low<high){
            
            char lowchar=Character.toLowerCase(s.charAt(low));
            char highchar=Character.toLowerCase(s.charAt(high));
         if(Character.isLetterOrDigit(lowchar) && Character.isLetterOrDigit(highchar)){
               if(lowchar!=highchar) return false;
                else{
                  low++;
                  high--;

                }
            }
            
            else if(Character.isLetterOrDigit(lowchar)){
                high--;

            }
            else{
                  low++;
            }

        }
        
        return true;
    }
}