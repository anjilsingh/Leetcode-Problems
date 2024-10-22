class Solution {
      public String gcdOfStrings(String str1, String str2) {
          //logic base case since it has gcd at one time there length must be equal 
          
          if(str1.equals(str2)){
            return str1;
          }
          String maxString=str1;
          String minString=str2;
          
          if(str2.length()>str1.length()){
              maxString=str2;
              minString=str1;
              
          }
          
          if(maxString.indexOf(minString)!=0){
            return "";
          }
          
          return gcdOfStrings(minString,maxString.substring(minString.length()));
          
}
}