import java.util.Arrays;

class Solution {
  public int countCoveredBuildings(int n, int[][] buildings) {
    int[] top = new int[n + 1];
    int[] bottom = new int[n + 1];
    int[] left = new int[n + 1];
    int[] right = new int[n + 1];

    Arrays.fill(top, Integer.MAX_VALUE);
    Arrays.fill(left, Integer.MAX_VALUE);

    for (int i = 0; i < buildings.length; i++) {
      int x = buildings[i][0];
      int y = buildings[i][1];

      top[x] = Math.min(top[x], y);
      bottom[x] = Math.max(bottom[x], y);
      left[y] = Math.min(left[y], x);
      right[y] = Math.max(right[y], x);
    }

    int count = 0;

    for (int i = 0; i < buildings.length; i++) {
      int x = buildings[i][0];
      int y = buildings[i][1];
      if (top[x] < y && bottom[x] > y && left[y] < x && right[y] > x) {
        count++;
      }
    }

    return count;
  }
}