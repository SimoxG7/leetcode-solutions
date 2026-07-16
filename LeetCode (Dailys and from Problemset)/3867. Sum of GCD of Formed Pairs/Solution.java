import java.util.Arrays;

class Solution {
  public long gcdSum(int[] nums) {
    int n = nums.length;
    int[] prefixGcd = new int[n];
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int num = nums[i];
      max = Math.max(num, max);
      prefixGcd[i] = gcd(num, max);
    }

    // ignored sort direction because of how their values are used
    Arrays.sort(prefixGcd);

    long sum = 0;
    for (int i = 0; i < n / 2; i++) {
      sum += gcd(prefixGcd[i], prefixGcd[n - 1 - i]);
    }
    return sum;
  }

  // Euclid GCD
  private static int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}