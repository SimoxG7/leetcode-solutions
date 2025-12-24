
import java.util.Arrays;

class Solution {
  public int minimumBoxes(int[] apple, int[] capacity) {
    int n = apple.length, m = capacity.length;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += apple[i];
    }
    Arrays.sort(capacity);
    while (sum > 0) {
      for (int i = m - 1; i >= 0; i--) {
        sum -= capacity[i];
        if (sum <= 0) {
          return m - i;
        }
      }
    }
    return m;
  }
}