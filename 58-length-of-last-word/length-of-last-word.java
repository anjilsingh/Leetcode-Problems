class Solution {
    public int lengthOfLastWord(String s) {
    
      s=s.trim();
      int n=s.length();
        // if(n==1){
        //   if(s.charAt(0)!=' '){
        //     return 1;
        //   }
        //     else{
        //     return 0;
        //     }
        // }
        int len=0;
      for(int i=n-1;i>=0;i--){
          if(s.charAt(i)!=' '){
              len++;
          }
          else{
             if(len>0){
               break;
              }
          }
          
      }
        return len;
      
    }
}