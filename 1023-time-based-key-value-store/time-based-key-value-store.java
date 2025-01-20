class Pair{
    String val;
    int ts;
    Pair(String val,int ts){
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
        ArrayList<Pair>al=mp.get(key);
        int low=0;
        int high=al.size()-1;
           String ans="";
        while(low<=high){
            int mid=(low+high)/2;

            if(al.get(mid).ts==timestamp){
                ans=al.get(mid).val;
                return ans;
            }
            if(al.get(mid).ts<timestamp){
                ans=al.get(mid).val;
                low=mid+1;
            }
            else{
                high=mid-1;
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