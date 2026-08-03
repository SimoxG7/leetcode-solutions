class Solution {
  public String stoneGameIII(int[] stoneValue) {
    int n = stoneValue.length;
    Integer[] memo = new Integer[n];
    int dif = helper(stoneValue, n, 0, memo);
    if (dif > 0) {
      return "Alice";
    } else if (dif < 0) {
      return "Bob";
    } else {
      return "Tie";
    }
  }

  private int helper(int[] stoneValue, int n, int i, Integer[] memo) {
    if (i == n) {
      return 0;
    }
    if (memo[i] != null) {
      return memo[i];
    }
    int result = stoneValue[i] - helper(stoneValue, n, i + 1, memo);
    if (i + 2 <= n) {
      result = Math.max(result, stoneValue[i]
          + stoneValue[i + 1] - helper(stoneValue, n, i + 2, memo));
    }
    if (i + 3 <= n) {
      result = Math.max(result, stoneValue[i] + stoneValue[i + 1]
          + stoneValue[i + 2] - helper(stoneValue, n, i + 3, memo));
    }
    memo[i] = result;
    return result;
  }
}