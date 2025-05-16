import java.util.*;

class Solution {
  public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
    int n = words.length;
    int[] dp = new int[n];
    int[] prev = new int[n];
    Arrays.fill(dp, 1);
    Arrays.fill(prev, -1);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (groups[i] != groups[j] &&
            words[i].length() == words[j].length() &&
            hammingDistance(words[i], words[j]) == 1) {
          if (dp[j] + 1 > dp[i]) {
            dp[i] = dp[j] + 1;
            prev[i] = j;
          }
        }
      }
    }

    int maxIndex = 0;
    for (int i = 1; i < n; i++) {
      if (dp[i] > dp[maxIndex]) {
        maxIndex = i;
      }
    }

    List<String> result = new ArrayList<>();
    while (maxIndex != -1) {
      result.add(words[maxIndex]);
      maxIndex = prev[maxIndex];
    }
    Collections.reverse(result);
    return result;
  }

  private int hammingDistance(String a, String b) {
    int dist = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i))
        dist++;
    }
    return dist;
  }
}