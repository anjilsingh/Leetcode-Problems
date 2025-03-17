class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length()) return false;
        int matches=0;
        int l=0;
        int[] s1arr=new int[26];
        int[] s2arr=new int[26];
        for(int i=0;i<s1.length();i++){
            s1arr[s1.charAt(i)-'a']++;
            s2arr[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(s1arr[i]==s2arr[i]){
                matches++;
            }
        }
        for(int r=s1.length();r<s2.length();r++){
            if(matches==26) return true;
            int index=s2.charAt(r)-'a';
            s2arr[index]++;
            if(s1arr[index]==s2arr[index]) matches++;
            if(s1arr[index]+1==s2arr[index]) matches--;

            index=s2.charAt(l)-'a';
            s1arr[index]++;
            if(s1arr[index]==s2arr[index]) matches++;
            if(s1arr[index]==s2arr[index]+1) matches--;
            l++;
        }
        return matches==26;
    }
}