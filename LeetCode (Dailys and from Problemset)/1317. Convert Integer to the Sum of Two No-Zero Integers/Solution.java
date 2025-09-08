class Solution {
  public int[] getNoZeroIntegers(int n) {
    for (int i = n - 1; i > 0; i--) {
      if (!containsZero(i) && !containsZero(n - i)) return new int[] {i, n - i};
    }
    return new int[2]; //impossible
  }

  private boolean containsZero(int n) {
    while (n >= 10) {
      if (n % 10 == 0) return true;
      n /= 10;
    }
    return n == 0;
  }
}