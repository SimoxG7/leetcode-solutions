import java.util.Arrays;

class Solution {
  public int longestIdealString(String s, int k) {
    int n = s.length();
    int[] dp = new int[n];
    int[] lastOccur = new int[26];
    Arrays.fill(lastOccur, -1);
    Arrays.fill(dp, 1);
    lastOccur[s.charAt(0) - 'a'] = 0;
    int max = 1;
    for (int i = 1; i < n; i++) {
      char newEnd = s.charAt(i);
      for (int j = Math.max('a' - newEnd, -k); j <= Math.min('z' - newEnd, k); j++) {
        char target = (char) (newEnd + j);
        int potentialPrevIdx = lastOccur[target - 'a'];
        if (potentialPrevIdx != -1) {
          dp[i] = Math.max(dp[i], dp[potentialPrevIdx] + 1);
        }
      }
      max = Math.max(dp[i], max);
      lastOccur[newEnd - 'a'] = i;
    }
    return max;
  }
}