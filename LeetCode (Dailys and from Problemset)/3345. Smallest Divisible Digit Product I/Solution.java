class Solution {
  public int smallestNumber(int n, int t) {
    for (int i = n; i <= 100; i++) {
      int rem1 = i % 10;
      int rem2 = Math.max((i / 10) % 10, 1);
      if (rem1 * rem2 % t == 0) {
        return i;
      }
    }
    return 0;
  }
}