package jamal;

import java.util.*;
class Twitter {

    Map<Integer, Set<Integer>> followMap = new HashMap();
    PriorityQueue<long[]> pq = new PriorityQueue<long[]>((long[] a, long[] b) -> {
        if (b[2] == a[2]) {
            return (int) (b[3] - a[3]);
        }
        return (int) ((long) b[2] - (long) a[2]);
    });
    int counter;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        pq.add(new long[]{userId, tweetId, System.currentTimeMillis(), counter++});
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<long[]> tmp = new ArrayList();
        List<Integer> result = new ArrayList();
        while (!pq.isEmpty()) {
            long[] cell = pq.poll();
            int uId = (int) cell[0];
            long tweetId = cell[1];
            if (userId == uId) {
                result.add((int) tweetId);
            } else if (followMap.containsKey(userId) && followMap.get(userId).contains(uId)) {
                result.add((int) tweetId);
            }
            tmp.add(cell);
            if (result.size() == 10) {
                break;
            }

        }
        pq.addAll(tmp);
        System.out.println(" 2----  " + followMap + " " + Arrays.deepToString(pq.toArray()));
        return result;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!followMap.containsKey(followerId)) {
            followMap.put(followerId, new HashSet());
            followMap.get(followerId).add(followerId);
        }
        followMap.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followMap.containsKey(followerId)) {
            return;
        }
        followMap.get(followerId).remove(followeeId);
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