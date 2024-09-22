class Solution {
  public int findKthNumber(int n, int k) {
    int current = 1;
    k--;

    while (k > 0) {
      int count = countPrefix(current, n);
      if (count <= k) {
        current++;
        k -= count;
      } else {
        current *= 10;
        k--;
      }
    }
    return current;
  }

  private int countPrefix(int prefix, int n) {
    long curr = prefix;
    long next = prefix + 1;
    int count = 0;

    while (curr <= n) {
      count += Math.min(n + 1, next) - curr;
      curr *= 10;
      next *= 10;
    }
    return count;
  }
}