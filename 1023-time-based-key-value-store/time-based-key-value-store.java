class TimeMap {
    private static class Pair{
      int ts;
     String val;
     Pair(int ts,String val){
        this.ts=ts;
        this.val=val;
     }
    }
     //first create a hashmap
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
        List<Pair>list=mp.get(key);
       String res="";
       int left=0;
       int right=list.size()-1;
        while(left<=right){
          int mid=left+(right-left)/2;
          if(list.get(mid).ts<=timestamp){
              res=list.get(mid).val;
              left=mid+1;
          }
            else{
                 right=mid-1;
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */