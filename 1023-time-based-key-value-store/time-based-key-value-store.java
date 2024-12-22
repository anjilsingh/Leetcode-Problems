class TimeMap {
    public static class Pair{
      int ts;
      String val;
        Pair(int ts,String val){
            this.ts=ts;
            this.val=val;
        }
    }
    
    HashMap<String,List<Pair>>mp;
    public TimeMap() {
        mp=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(new Pair(timestamp,value));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)) return "";
        String ans="";
        List<Pair>al=mp.get(key);
        
        int l=0;
        int r=al.size()-1;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(al.get(mid).ts==timestamp) return al.get(mid).val;
            else if(al.get(mid).ts<timestamp)
            {ans= al.get(mid).val;
              l=mid+1;
             }
            else {
              r=mid-1;
            }
        }
        
        return ans;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */