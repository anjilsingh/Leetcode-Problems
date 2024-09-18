class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character>mpp=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(mpp.containsKey(s.charAt(i))&& mpp.get(s.charAt(i))!=t.charAt(i) ){
              return false;
            }
           mpp.put(s.charAt(i),t.charAt(i));
        }
        
         Map<Character,Character>mpp2=new HashMap<>();
        for(int i=0;i<t.length();i++){
            if(mpp2.containsKey(t.charAt(i))&& mpp2.get(t.charAt(i))!=s.charAt(i) ){
              return false;
            }
           mpp2.put(t.charAt(i),s.charAt(i));
        }
       return true; 
    }
}