import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Tweet{
    int tweetid;
    int userid;
    Tweet next;
    Tweet(int tweetid,int userid){
        this.tweetid = tweetid;
        this.userid = userid;
        this.next = null;
    }
}

class Twitter {
    private HashMap<Integer, List<Integer>> users;
    private Tweet head;

    public Twitter() {
        this.users = new HashMap<>();
        this.head = new Tweet(0,0);
    }

    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            users.put(userId, new ArrayList<>(Arrays.asList(userId)));
        }
        Tweet newTweet = new Tweet(tweetId,userId);
        newTweet.next = head.next;
        head.next = newTweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        Tweet temp = head.next;
        List<Integer> following = users.get(userId);
        while(newsFeed.size()<10 && temp != null ){
            if(following != null && following.contains(temp.userid)){
                newsFeed.add(temp.tweetid);
            }
            temp = temp.next;
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
            users.put(followerId, new ArrayList<>());
            users.get(followerId).add(followerId);
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
            users.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}

class TwitterMain{
    public static void main(String[] args){
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]
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