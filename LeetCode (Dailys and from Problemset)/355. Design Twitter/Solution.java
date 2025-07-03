import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
// import java.util.stream.Collectors;
import java.util.Set;

class Twitter {

  private final Map<Integer, Set<Integer>> userPosts;
  private final Map<Integer, Set<Integer>> followedMap; //followeds from follower
  // private final Map<Integer, Set<Integer>> followerMap; //followers from followed
  private final Map<Integer, Integer> tweetToOrderedId;
  private int tweetCounter;

  public Twitter() {
    userPosts = new HashMap<>();
    followedMap = new HashMap<>();
    // followerMap = new HashMap<>();
    tweetToOrderedId = new HashMap<>();
    tweetCounter = 1;
  }

  public void postTweet(int userId, int tweetId) {
    Set<Integer> tweets = userPosts.getOrDefault(userId, new HashSet<>());
    tweets.add(tweetId);
    userPosts.put(userId, tweets);
    tweetToOrderedId.put(tweetId, tweetCounter++);
    // System.out.println("User [" + userId + "] tweets [" + tweetId + "]. Current tweets for user: [" + tweets + "]");
  }

  public List<Integer> getNewsFeed(int userId) {
    List<Integer> accumulator = new ArrayList<>(userPosts.getOrDefault(userId, new HashSet<>()));
    Set<Integer> followedList = followedMap.getOrDefault(userId, new HashSet<>());
    for (int followedId : followedList) {
      Set<Integer> posts = userPosts.get(followedId);
      if (Objects.isNull(posts)) continue;
      accumulator.addAll(List.copyOf(posts));
    }
    Collections.sort(accumulator, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return tweetToOrderedId.get(o2) - tweetToOrderedId.get(o1); //reversed cause i want new as first
      }
    });
    // System.out.println("NewsFeed for user [" + userId + "] is: " + accumulator.subList(0, Math.min(10, accumulator.size())));
    return accumulator.subList(0, Math.min(10, accumulator.size()));
  }

  public void follow(int followerId, int followeeId) {
    Set<Integer> followeds = followedMap.getOrDefault(followerId, new HashSet<>());
    followeds.add(followeeId);
    followedMap.put(followerId, followeds);

    // Set<Integer> followers = followerMap.getOrDefault(followeeId, new HashSet<>());
    // followers.add(followerId);
    // followerMap.put(followeeId, followers);
    // System.out.println("User [" + followerId + "] now follows [" + followeeId + "]. User [" + followerId + "] follows " + followeds + ". User [" + followeeId + "] is followed by " + followers);
  }

  public void unfollow(int followerId, int followeeId) {
    // Set<Integer> followers = followerMap.get(followeeId);
    // if (Objects.nonNull(followers)) {
    //   followers.remove(Integer.valueOf(followerId));
    //   followerMap.put(followeeId, followers);
    // }

    Set<Integer> followeds = followedMap.get(followerId);
    if (Objects.nonNull(followeds)) {
      followeds.remove(Integer.valueOf(followeeId));
      followedMap.put(followerId, followeds);
    }
    // System.out.println("User [" + followerId + "] now unfollows [" + followeeId + "]. User [" + followerId + "] follows " + followeds + ". User [" + followeeId + "] is followed by " + followers);
  }

  // private String mapToString(Map<?, ?> map) {
  //   String mapAsString = map.keySet().stream()
  //     .map(key -> key + "=" + map.get(key))
  //     .collect(Collectors.joining(", ", "{", "}"));
  //   return mapAsString;
  // }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */