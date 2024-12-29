class Solution {
    public boolean isAnagram(String s, String t) {
        //three aproach
        //sort, hashmap,hash table

        char[] schar=s.toCharArray();
        Arrays.sort(schar);
        String sorS=new String(schar);
        char[] tchar=t.toCharArray();
        Arrays.sort(tchar);
        String sorT=new String(tchar);
        Arrays.sort(tchar);


        return sorS.equals(sorT);

    }
}