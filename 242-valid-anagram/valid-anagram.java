class Solution {
    public boolean isAnagram(String s, String t) {

        //tc o(log n)
        if(s.length() !=t.length()){
            return false;
        }
        char[] scharArr=s.toCharArray();
        char[] tcharArr=t.toCharArray();
        Arrays.sort(scharArr);
        Arrays.sort(tcharArr);
        String sortedS=new String(scharArr);
        String sortedT=new String(tcharArr);
        for(int i=0;i<s.length();i++){
            if(sortedS.charAt(i)!=sortedT.charAt(i)){
                return false;
            }
        }
        return true;
    }
}