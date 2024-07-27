public class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    int n = original.length;
    int m = source.length();

    long[][] dp = new long[26][26];
    for (int i = 0; i < 26; i++) {
      for (int j = 0; j < 26; j++) {
        dp[i][j] = Long.MAX_VALUE;
      }
    }

    for (int i = 0; i < 26; i++) {
      dp[i][i] = 0;
    }

    for (int i = 0; i < n; i++) {
      dp[original[i] - 'a'][changed[i] - 'a'] = Math.min(dp[original[i] - 'a'][changed[i] - 'a'], (long) cost[i]);
    }

    // Floyd-Warshall algorithm to find shortest path
    for (int via = 0; via < 26; via++) {
      for (int i = 0; i < 26; i++) {
        for (int j = 0; j < 26; j++) {
          if (dp[i][via] != Long.MAX_VALUE && dp[via][j] != Long.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], dp[i][via] + dp[via][j]);
          }
        }
      }
    }

    long ans = 0;

    for (int i = 0; i < m; i++) {
      if (dp[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Long.MAX_VALUE) {
        return -1;
      }
      ans += dp[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
    }

    return ans;
  }
}