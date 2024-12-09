class Solution {
    public boolean isAnagram(String s, String t) {
        //anagrams means same length and same character 
        //can use sorting or hashmap or use a hashtable 
        
        if(s.length()!=t.length()) return false;
        
        char[] scharArr=s.toCharArray();
        char[] tcharArr=t.toCharArray();
        Arrays.sort(scharArr);
        Arrays.sort(tcharArr);
        String sortedS=new String(scharArr);
        String sortedT=new String(tcharArr);
        return sortedS.equals(sortedT);
    }
}