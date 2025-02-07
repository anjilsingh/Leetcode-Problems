public class Pair{
    String val;
    int ts;
    Pair(String val, int ts){
        this.val=val;
        this.ts=ts;
    }
}
class TimeMap {
     HashMap<String,List<Pair>>mp;
    public TimeMap() {
        mp=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        mp.putIfAbsent(key,new ArrayList<>());
        mp.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key)){
            return "";
        }

        List<Pair>al=mp.get(key);
         String res="";
        int l=0;
        int r=al.size()-1;
        while(l<=r){
            int mid=(l+r)/2;

            Pair pair=al.get(mid);

            int t=pair.ts;

            if(t<=timestamp){
               res=pair.val;
               l=mid+1;
            }
            else{
                r=mid-1;
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