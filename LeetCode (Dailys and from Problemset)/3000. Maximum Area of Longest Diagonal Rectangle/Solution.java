import java.util.ArrayList;
import java.util.List;

class Solution {
  public int areaOfMaxDiagonal(int[][] dimensions) {
    double maxDiagonal = 0;
    List<int[]> bestDiagonalDimensions = new ArrayList<>();
    for (int i = 0; i < dimensions.length; i++) {
      double diagonal = Math.sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);
      if (diagonal > maxDiagonal) {
        maxDiagonal = diagonal;
        bestDiagonalDimensions = new ArrayList<>();
        bestDiagonalDimensions.add(dimensions[i]);
      } else if (diagonal == maxDiagonal) {
        bestDiagonalDimensions.add(dimensions[i]);
      }
    }
    int maxArea = 0;
    for (int[] possibleBestDiagonalDimension : bestDiagonalDimensions) {
      maxArea = Math.max(maxArea, possibleBestDiagonalDimension[0] * possibleBestDiagonalDimension[1]);
    }
    return maxArea;
  }
}