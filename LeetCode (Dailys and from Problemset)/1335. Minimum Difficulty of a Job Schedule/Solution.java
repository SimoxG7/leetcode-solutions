import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  public int minDifficulty(int[] jobDifficulty, int d) {
    int n = jobDifficulty.length;
    if (n < d) {
      return -1;
    } else if (n == d) {
      int totalDifficulty = 0;
      for (int difficulty : jobDifficulty) {
        totalDifficulty += difficulty;
      }
      return totalDifficulty;
    }
    int[] dp = new int[n];
    dp[0] = jobDifficulty[0];
    for (int i = 1; i < n; i++) {
      dp[i] = Math.max(jobDifficulty[i], dp[i - 1]);
    }
    int[] dpPrev = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 1; i < d; i++) {
      int[] temp = dp;
      dp = dpPrev;
      dpPrev = temp;
      stack.clear();
      for (int j = i; j < n; j++) {
        dp[j] = jobDifficulty[j] + dpPrev[j - 1];
        while (!stack.isEmpty() && jobDifficulty[stack.peekLast()] <= jobDifficulty[j]) {
          int lastIdx = stack.pollLast();
          dp[j] = Math.min(dp[j], dp[lastIdx] + jobDifficulty[j] - jobDifficulty[lastIdx]);
        }
        if (!stack.isEmpty()) {
          dp[j] = Math.min(dp[j], dp[stack.peekLast()]);
        }
        stack.addLast(j);
      }
    }
    return dp[n - 1];
  }
}
