class Solution {
    public boolean isAnagram(String s, String t) {
        //second method can use an int array 
        //increase value for char in s and decrease for t if all are 0 then okay else return false
        //since only lower case letter so use 26 length array
        
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
           arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
             arr[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
           if(arr[i]!=0) return false;
        }
        return true;
    }
}