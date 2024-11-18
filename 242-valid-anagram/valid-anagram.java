class Solution {
    public boolean isAnagram(String s, String t) {
        //third method --its my try 
        if(s.length()!=t.length()) return false;
        HashMap<Character,Integer>mS=new HashMap<>();
        HashMap<Character,Integer>mT=new HashMap<>();
         
        for(char ch:s.toCharArray()){
         mS.put(ch,mS.getOrDefault(ch,0)+1);
        }
        
        for(char ch:t.toCharArray()){
             mT.put(ch,mT.getOrDefault(ch,0)+1);
        }
        
        for(char ch:s.toCharArray()){
            int valS=mS.get(ch);
            if(mT.containsKey(ch)){
               int valT=mT.get(ch);
              if(valS!=valT) return false;
            }
            else{
               return false;
            }
           

        }
        return true;
    }
}