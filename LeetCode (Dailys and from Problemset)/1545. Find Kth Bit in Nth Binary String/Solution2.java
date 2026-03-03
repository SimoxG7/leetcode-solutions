class Solution {
  public char findKthBit(int n, int k) {
    StringBuilder current = new StringBuilder("0");
    for (int i = 1; i < n; i++) {
      StringBuilder prev = current;
      StringBuilder rev = new StringBuilder();
      for (int j = prev.length() - 1; j >= 0; j--) {
        if (prev.charAt(j) == '1') {
          rev.append('0');
        } else {
          rev.append('1');
        }
      }
      current = prev.append("1").append(rev);
    }
    return current.charAt(k - 1);
  }
}