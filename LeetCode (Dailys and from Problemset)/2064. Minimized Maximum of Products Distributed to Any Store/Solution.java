class Solution {
  public int minimizedMaximum(int n, int[] quantities) {
    int left = 1;
    int right = quantities[0];
    for (int i = 1; i < quantities.length; i++) {
      right = Math.max(right, quantities[i]);
    }

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int total = 0;
      for (int element : quantities) {
        total += (element + mid - 1) / mid;
      }

      if (total <= n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    
    return left;
  }
}