import java.util.*;

public class Twitter {
    public class Pair implements Comparable<Pair> {
        int id;
        int time;

        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(Pair p) {
            return this.time - p.time;
        }
    }

    HashMap<Integer, ArrayList<Pair>> userIdMap;
    HashMap<Integer, HashSet<Integer>> followMap;
    PriorityQueue<Pair> p;
    int time;

    public Twitter() {
        userIdMap = new HashMap<>();
        followMap = new HashMap<>();
        time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        userIdMap.putIfAbsent(userId, new ArrayList<>());
        userIdMap.get(userId).add(new Pair(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        p = new PriorityQueue<>((a, b) -> b.time - a.time); // Max-heap
        List<Integer> ans = new ArrayList<>();

        // Get user's own tweets
        ArrayList<Pair> helper = userIdMap.get(userId);
        if (helper != null) {
            p.addAll(helper);
        }

        // Get tweets from followed users
        HashSet<Integer> helper2 = followMap.get(userId);
        if (helper2 != null) {
            for (int key : helper2) {
                ArrayList<Pair> helper3 = userIdMap.get(key);
                if (helper3 != null) {
                    p.addAll(helper3);
                }
            }
        }

        while (!p.isEmpty() && ans.size() < 10) {
            ans.add(p.poll().id);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
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