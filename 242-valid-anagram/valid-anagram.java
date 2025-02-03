class Solution {
    public boolean isAnagram(String s, String t) {
        

        char[] schar=s.toCharArray();
        char[] tchar=t.toCharArray();
        Arrays.sort(schar);
        Arrays.sort(tchar);

        String sortedS=Arrays.toString(schar);
        String sortedT=Arrays.toString(tchar);

        return sortedS.equals(sortedT);
    }
}