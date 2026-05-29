class Solution {
  public int minElement(int[] nums) {
    int minSum = Integer.MAX_VALUE;
    for (int num : nums) {
      minSum = Math.min(sumDigits(num), minSum);
    }
    return minSum;
  }

  private int sumDigits(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}