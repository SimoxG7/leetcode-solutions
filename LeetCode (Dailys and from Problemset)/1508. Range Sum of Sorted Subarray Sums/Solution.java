import java.util.Arrays;

class Solution {
  private static final int MOD = 1000000007;

  public int rangeSum(int[] nums, int n, int left, int right) {

    int[] subArray = new int[(n * (n + 1)) / 2];
    int idx = 0;
    for (int i = 0; i < nums.length; i++) {
      int currentSum = 0;
      for (int j = i; j < nums.length; j++) {
        currentSum += nums[j];
        subArray[idx++] = currentSum;
      }
    }
    Arrays.sort(subArray);
    int sum = 0;
    for (int i = left - 1; i < right; i++) {
      sum = (sum + subArray[i]) % MOD;
    }

    return sum;
  }
}