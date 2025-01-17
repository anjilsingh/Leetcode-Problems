 public class Pair{
    String val;
    int ts;
    public Pair(String val, int ts){
        this.val=val;
        this.ts=ts;
    }
 }
class TimeMap {
   HashMap<String,ArrayList<Pair>>mp;
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
        String res="";
        List<Pair>al=mp.get(key);
        int low=0;
        int high=al.size()-1;
        while(low<=high){
            int mid=(low+high)/2;
            
            int timeS=al.get(mid).ts;
            if(timeS==timestamp){
                res=al.get(mid).val;
                return res;
            }
            else if(timeS<timestamp){
                res=al.get(mid).val;
                low=mid+1;
            }
            else{
                high=mid-1;
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