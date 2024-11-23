class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0) return "";
        
        HashMap<Character,Integer>tmp=new HashMap<>();
        HashMap<Character,Integer>smp=new HashMap<>();
        
        for(char c:t.toCharArray()){
              tmp.put(c,tmp.getOrDefault(c,0)+1);
        }
        int need=tmp.size();
        
        int ind[]={-1,-1};
        int have=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
        
            
          if (tmp.containsKey(ch)) {
                smp.put(ch, smp.getOrDefault(ch, 0) + 1);
                if (smp.get(ch).equals(tmp.get(ch))) {
                    have++;
                }
            }

            while(have==need){
               
                if(ind[0]==-1 || (ind[1]-ind[0]+1)>=r-l+1){

                 ind[0]=l;
                 ind[1]=r;
                }
                
                //now remove the character from l pointer side
                
                char c=s.charAt(l);
               
                
     if (tmp.containsKey(c)) {
                    smp.put(c, smp.get(c) - 1);
                    if (smp.get(c) < tmp.get(c)) {
                        have--;
                    }
                    if (smp.get(c) == 0) {
                        smp.remove(c);
                    }
                }
                l++;

            }

        
        }
        
        if(ind[0]==-1) return "";
        return s.substring(ind[0],ind[1]+1);
    }
}