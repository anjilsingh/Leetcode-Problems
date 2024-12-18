class Solution {
    public boolean isAnagram(String s, String t) {
        //anagram means same character 
        //so we have two options one to 
        //soet the strings or can use a hashtable 
        // or hashmap
        if(s.length()!=t.length()) return false;
       HashMap<Character,Integer>ms=new HashMap<>();
       HashMap<Character,Integer>mt=new HashMap<>();
       
      for(int i=0;i<s.length();i++){
           ms.put(s.charAt(i),ms.getOrDefault(s.charAt(i),0)+1);
           mt.put(t.charAt(i),mt.getOrDefault(t.charAt(i),0)+1);
      }
        
     return ms.equals(mt);
    }
}