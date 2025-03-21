class Solution {
    public boolean alphaNum(char c){
        return (c>='a'&& c<='z' || c>='A' && c<='Z' ||c>='0' && c<='9');
    }
    public boolean isPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            while(l<r && !alphaNum(s.charAt(l))){
                l++;
            }
            while(l<r && !alphaNum(s.charAt(r))){
                r--;
            }

 if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}