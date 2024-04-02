import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    int n = buildings.length;
    int[] xAxis = new int[2 * n];
    int[] heights = new int[2 * n];

    for (int i = 0; i < n; i++) {
      xAxis[2 * i] = buildings[i][0];
      xAxis[2 * i + 1] = buildings[i][1];
    }

    Arrays.sort(xAxis);
    for (int i = 0; i < n; i++) {
      int leftIndex = Arrays.binarySearch(xAxis, buildings[i][0]);
      int rightIndex = Arrays.binarySearch(xAxis, buildings[i][1]);
      for (int j = leftIndex; j < rightIndex; j++) {
        heights[j] = Math.max(heights[j], buildings[i][2]);
      }
    }

    int lastBuildingHeight = 0;
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < 2 * n; i++) {
      if (heights[i] != lastBuildingHeight) {
        ans.add(Arrays.asList(xAxis[i], heights[i]));
        lastBuildingHeight = heights[i];
      }
    }
    return ans;
  }
}
