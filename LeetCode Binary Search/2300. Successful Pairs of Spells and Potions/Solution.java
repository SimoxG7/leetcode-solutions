import java.util.Arrays;

class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
    int n = spells.length;
    int m = potions.length;
    int[] res = new int[n];
    Arrays.sort(potions);
    for (int i = 0; i < n; i++) {
      int left = 0;
      int right = m - 1;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        long product = (long) spells[i] * potions[mid];
        if (product >= success) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      res[i] = m - left;
    }
    return res;
  }
}