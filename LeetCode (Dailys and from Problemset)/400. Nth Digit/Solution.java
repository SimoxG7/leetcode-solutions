class Solution {
  public int findNthDigit(int n) {
    int len = 1, i = 1;
    long range = 9;
    while (n > len * range) {
      n -= len * range;
      len++;
      range *= 10;
      i *= 10;
    }

    i += (n - 1) / len;
    String s = Integer.toString(i);
    return Character.getNumericValue(s.charAt((n - 1) % len));
  }
}