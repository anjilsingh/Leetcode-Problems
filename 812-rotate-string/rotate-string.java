class Solution {
    public boolean rotateString(String s, String goal) {
        //basic if the length is not equal directly return false 
        if(s.length()!=goal.length()) return false;
        return (s+s).contains(goal);
    }
}