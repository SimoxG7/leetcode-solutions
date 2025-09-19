import java.util.HashSet;
import java.util.Set;

class Solution {
  public boolean isRectangleCover(int[][] rectangles) {
    int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;
    long totalArea = 0;

    Set<String> cornerSet = new HashSet<>();

    for (int[] rect : rectangles) {
      int x1 = rect[0], y1 = rect[1];
      int x2 = rect[2], y2 = rect[3];
      minX = Math.min(minX, x1);
      minY = Math.min(minY, y1);
      maxX = Math.max(maxX, x2);
      maxY = Math.max(maxY, y2);
      totalArea += (long) (x2 - x1) * (y2 - y1);
      String[] corners = {
          x1 + "," + y1, x1 + "," + y2,
          x2 + "," + y1, x2 + "," + y2
      };

      for (String corner : corners) {
        if (!cornerSet.add(corner)) {
          cornerSet.remove(corner);
        }
      }
    }
    long boundingArea = (long) (maxX - minX) * (maxY - minY);
    if (totalArea != boundingArea)
      return false;

    if (cornerSet.size() != 4 ||
        !cornerSet.contains(minX + "," + minY) ||
        !cornerSet.contains(minX + "," + maxY) ||
        !cornerSet.contains(maxX + "," + minY) ||
        !cornerSet.contains(maxX + "," + maxY)) {
      return false;
    }

    return true;
  }
}