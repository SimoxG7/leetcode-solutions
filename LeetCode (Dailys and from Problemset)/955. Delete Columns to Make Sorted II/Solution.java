class Solution {
  public int minDeletionSize(String[] strs) {
    int len = strs.length;
    int str0Len = strs[0].length();
    boolean[] sorted = new boolean[len - 1];
    int delete = 0;
    for (int col = 0; col < str0Len; col++) {
      boolean needDelete = false;
      for (int row = 0; row < len - 1; row++) {
        if (!sorted[row] && strs[row].charAt(col) > strs[row + 1].charAt(col)) {
          needDelete = true;
          break;
        }
      }
      if (needDelete) {
        delete++;
        continue;
      }
      for (int row = 0; row < len - 1; row++) {
        if (!sorted[row] && strs[row].charAt(col) < strs[row + 1].charAt(col))
          sorted[row] = true;
      }
    }
    return delete;
  }
}