class Solution {
  public int maxDistance(int[] colors) {
    int n = colors.length;
    int max = 0;
    for (int i = 0; i < n; i++) {
      int right = n - 1;
      for (int left = i; left <= right; right--) {
        if (colors[left] != colors[right]) max = Math.max(max, right - left);
      }
      if (max >= n - i) return max;
    }
    return max;
  }
}