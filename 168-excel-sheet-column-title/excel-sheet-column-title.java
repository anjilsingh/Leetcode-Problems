class Solution {
    public String convertToTitle(int columnNumber) {
        
        //create a strigbuilder 
        StringBuilder sb=new StringBuilder();
        while(columnNumber>0){
           columnNumber--;
           int remainder=columnNumber%26;
           sb.append((char)('A'+remainder));
           columnNumber=columnNumber/26;
        
        }
        return sb.reverse().toString();
    }
}