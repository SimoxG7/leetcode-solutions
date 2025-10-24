class Solution {
  public int nextBeautifulNumber(int n) {
    for (int i = n + 1; i <= 1224444; i++) {
      if (isBalanced(i)) return i;
    }
    return -1;
  }

  private boolean isBalanced(int x) {
    int[] count = new int[10];
    while (x > 0) {
      count[x % 10]++;
      x /= 10;
    }

    for (int d = 0; d < 10; d++) {
      if (count[d] > 0 && count[d] != d) {
        return false;
      }
    }
    return true;
  }
}