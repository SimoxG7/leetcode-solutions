class Solution {

  private static final int[] POWERS_OF_10 = {1, 10, 100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000, 100_000_000, 1_000_000_000};

  public long sumAndMultiply(int n) {
    long curr = 0;
    int sum = 0;
    int exp = 0;
    while (n > 0) {
      int newDigit = n % 10;
      n /= 10;
      if (newDigit == 0) continue;
      curr += newDigit * POWERS_OF_10[exp++];
      sum += newDigit;
    }
    return curr * sum;
  }
}