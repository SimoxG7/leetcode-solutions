class Solution {
  public int integerBreak(int n) {
    if (n == 2 || n == 3)
      return n - 1;
    int result = 1;
    while (n > 4) {
      n -= 3;
      result *= 3;
    }
    return (n * result);
  }
}