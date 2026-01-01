class Solution {
  public int[] plusOne(int[] digits) {
    int n = digits.length;
    boolean over = false;
    for (int i = n-1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i] = digits[i] + 1;
        return digits;
      }
      digits[i] = 0;
      if (i == 0) over = true;
    }
    int[] res;
    if (over) {
      res = new int[n+1];
      for (int i = 0; i < n; i++) {
        res[i+1] = digits[i];
      }
      res[0] = 1;
    } else res = digits;
    return res;
  }
}