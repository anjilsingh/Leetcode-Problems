class Solution {
    public boolean isAnagram(String s, String t) {
        //anagram means same character 
        //so we have two options one to 
        //soet the strings or can use a hashtable 
        // or hashmap
        
        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        
        Arrays.sort(schar);
        String sorteds=new String(schar);
        Arrays.sort(tchar);
        String sortedt=new String(tchar);
        return sorteds.equals(sortedt);
    }
}