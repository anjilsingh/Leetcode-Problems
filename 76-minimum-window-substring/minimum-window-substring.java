class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        int minLength=Integer.MAX_VALUE;
        int[] index={-1,-1};
        HashMap<Character,Integer>tmp=new HashMap<>();
        for(int i=0;i<t.length();i++){
            tmp.put(t.charAt(i),tmp.getOrDefault(t.charAt(i),0)+1);
        }
        int need=tmp.size();
        int have=0;
        
        HashMap<Character,Integer>smp=new HashMap<>();
        int l=0;
        for(int r=0;r<s.length();r++){
           smp.put(s.charAt(r),smp.getOrDefault(s.charAt(r),0)+1);
           if(tmp.containsKey(s.charAt(r)) && smp.get(s.charAt(r)).equals(tmp.get(s.charAt(r)))){
            have++;
           }


           while(have==need){
              if(r-l+1<minLength){
                minLength=r-l+1;
                index[0]=l;
                index[1]=r;
              }

             smp.put(s.charAt(l), smp.getOrDefault(s.charAt(l), 0) - 1);

     if(tmp.containsKey(s.charAt(l)) && smp.get(s.charAt(l))<tmp.get(s.charAt(l))){
            have--;
           }
           l++;

           }
        }

        return minLength==Integer.MAX_VALUE?"":s.substring(index[0],index[1]+1);
        
    }
}