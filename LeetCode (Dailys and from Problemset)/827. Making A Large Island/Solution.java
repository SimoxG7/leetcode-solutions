import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  
  private int n;
  private int[][] grid;
  private Map<Integer, Integer> islandSizes = new HashMap<>();
  private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

  public int largestIsland(int[][] grid) {
    this.n = grid.length;
    this.grid = grid;
    int color = 2;
    int maxIsland = 0;
    boolean hasZero = false;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          int size = dfs(i, j, color);
          islandSizes.put(color, size);
          maxIsland = Math.max(maxIsland, size);
          color++;
        } else {
          hasZero = true;
        }
      }
    }

    if (!hasZero)
      return maxIsland;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 0) {
          Set<Integer> visitedIslands = new HashSet<>();
          int newSize = 1;

          for (int[] dir : DIRECTIONS) {
            int x = i + dir[0], y = j + dir[1];
            if (isValid(x, y) && grid[x][y] > 1 && visitedIslands.add(grid[x][y])) {
              newSize += islandSizes.get(grid[x][y]);
            }
          }

          maxIsland = Math.max(maxIsland, newSize);
        }
      }
    }

    return maxIsland;
  }

  private int dfs(int i, int j, int color) {
    if (!isValid(i, j) || grid[i][j] != 1)
      return 0;

    grid[i][j] = color;
    int size = 1;

    for (int[] dir : DIRECTIONS) {
      size += dfs(i + dir[0], j + dir[1], color);
    }

    return size;
  }

  private boolean isValid(int i, int j) {
    return i >= 0 && i < n && j >= 0 && j < n;
  }
}