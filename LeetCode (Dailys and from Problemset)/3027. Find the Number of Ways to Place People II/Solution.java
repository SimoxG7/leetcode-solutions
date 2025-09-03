import java.util.Arrays;

class Solution {
  public int numberOfPairs(int[][] points) {
    int n = points.length;

    // Sort first based on x coordinate in increasing order and
    // for equal xs sort based on y coordinate in descending order.
    // This gives the points on the upper left corner first and lower right corner
    // later while looping
    Arrays.sort(points, (a, b) -> {
      return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]);
    });

    int ans = 0;
    for (int i = 0; i < n; ++i) {
      int maxY = Integer.MIN_VALUE;
      for (int j = i + 1; j < n; ++j) {
        if (points[j][1] <= points[i][1]) {
          if (points[j][1] > maxY) { // only accept a new if his y is strictly higher than all previously accepted
            ans++;
            maxY = points[j][1];
          }
        }
      }
    }
    return ans;
  }
}