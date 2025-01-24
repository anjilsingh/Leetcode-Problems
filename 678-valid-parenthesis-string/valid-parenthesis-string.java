class Solution {
    public boolean checkValidString(String s) {
        int low=0;
        int high=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                low++;
                high++;
            }
            if(c==')'){
                low--;
                high--;
            }
            if(c=='*'){
                low=low-1;
                high=high+1;
            }
            low=Math.max(low,0);
            if(high<0){
                return false;
            }

        }
        return low==0;
    }
}