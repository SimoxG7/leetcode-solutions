import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
  private final int MOD = 1_000_000_007;

  public int countPartitions(int[] nums, int k) {
    int n = nums.length;
    long[] dp = new long[n + 1];
    long[] pre = new long[n + 1];
    dp[0] = 1;
    pre[0] = 1;

    Deque<Integer> max = new ArrayDeque<>();
    Deque<Integer> min = new ArrayDeque<>();

    int left = 0;

    for (int right = 0; right < n; right++) {

      while (!max.isEmpty() && nums[max.peekLast()] <= nums[right])
        max.pollLast();
      max.addLast(right);

      while (!min.isEmpty() && nums[min.peekLast()] >= nums[right])
        min.pollLast();
      min.addLast(right);

      while (nums[max.peekFirst()] - nums[min.peekFirst()] > k) {
        if (max.peekFirst() == left)
          max.pollFirst();
        if (min.peekFirst() == left)
          min.pollFirst();
        left++;
      }

      long ways = pre[right];
      if (left > 0)
        ways = (ways - pre[left - 1] + MOD) % MOD;

      dp[right + 1] = ways;
      pre[right + 1] = (pre[right] + dp[right + 1]) % MOD;
    }

    return (int) dp[n];
  }
}