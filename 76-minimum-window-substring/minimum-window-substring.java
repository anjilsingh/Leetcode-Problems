class Solution {
    public String minWindow(String s, String t) {
        //concept if need and have 
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        HashMap<Character,Integer>mpT=new HashMap<>();
        for(int i=0;i<t.length();i++){
            mpT.put(t.charAt(i),mpT.getOrDefault(t.charAt(i),0)+1);
        }
        int need=mpT.size();
        int have=0;
        int l=0;
        int len=s.length()+1;
        int[] index={-1,-1};
        HashMap<Character,Integer>mpS=new HashMap<>();
        for(int r=0;r<s.length();r++){
            mpS.put(s.charAt(r),mpS.getOrDefault(s.charAt(r),0)+1);
            if(mpT.containsKey(s.charAt(r)) && mpS.get(s.charAt(r)).equals(mpT.get(s.charAt(r)))){
                have++;
            }

            while(have==need){
                  if(r-l+1<len){
                     len=r-l+1;
                     index[0]=l;
                     index[1]=r;
                  }
                  mpS.put(s.charAt(l),mpS.getOrDefault(s.charAt(l),0)-1);
                 if(mpT.containsKey(s.charAt(l))){
                 if(mpS.get(s.charAt(l))<mpT.get(s.charAt(l))){
                    have--;
                 }
                 }
                 l++;
            }
        }
        if(len==s.length()+1) return "";
        return s.substring(index[0],index[1]+1);
    }
}