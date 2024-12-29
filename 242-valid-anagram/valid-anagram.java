class Solution {
    public boolean isAnagram(String s, String t) {
        //using two hashmap

        HashMap<Character,Integer>mpS=new HashMap<>();
        HashMap<Character,Integer>mpT=new HashMap<>();

        for(int i=0;i<s.length();i++){
            mpS.put(s.charAt(i),mpS.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0;i<t.length();i++){
            mpT.put(t.charAt(i),mpT.getOrDefault(t.charAt(i),0)+1);
        }

        return mpS.equals(mpT);
    }
}