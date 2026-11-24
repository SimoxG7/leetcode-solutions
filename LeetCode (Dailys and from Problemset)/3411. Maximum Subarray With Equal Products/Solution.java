class Solution {
  public int maxLength(int[] nums) {
    int n = nums.length;
    int res = 0;

    for (int i = 0; i < n; i++) {
      long product = 1;
      long lcm = 1;
      long gcd = 0;

      for (int j = i; j < n; j++) {
        product *= nums[j];

        gcd = gcd(gcd, nums[j]);
        lcm = lcm(lcm, nums[j]);

        if (product == gcd * lcm) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  private long gcd(long a, long b) {
    while (b != 0) {
      long temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  private long lcm(long a, long b) {
    return (a / gcd(a, b)) * b;
  }
}