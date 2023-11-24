class Solution {
  public int titleToNumber(String columnTitle) {
    int base = 1;
    int res = 0;
    for (int i = columnTitle.length() - 1; i >= 0; i--) {
      res += ((columnTitle.charAt(i) - 'A') + 1) * base;
      base *= 26;
    }
    return res;
  }
}