public class Pair{
    int id;
    int ts;
  public  Pair(int id,int ts){
        this.id=id;
        this.ts=ts;
    }

}
class Twitter {
    HashMap<Integer,ArrayList<Pair>>userMap;
    HashMap<Integer,Set<Integer>>followMap;
    int time;
    public Twitter() {
        userMap=new HashMap<>();
        followMap=new HashMap<>();
        time++;
    }
    
    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId,new ArrayList<>());
        userMap.get(userId).add(new Pair(tweetId,time++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->b.ts-a.ts);
        List<Integer>ans=new ArrayList<>();

        ArrayList<Pair> helper1=userMap.get(userId);
        if(helper1!=null){
            pq.addAll(helper1);
        }

    Set<Integer>helper2=followMap.get(userId);
    if(helper2!=null){
        for(int key:helper2){
            
        ArrayList<Pair> helper3=userMap.get(key);
        if(helper3!=null){
            pq.addAll(helper3);
        }
        }
    }

    while(!pq.isEmpty() && ans.size()<10)
    {
        ans.add(pq.poll().id);
    }

    return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */