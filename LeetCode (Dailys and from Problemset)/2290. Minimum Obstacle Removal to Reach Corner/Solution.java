import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
  public int minimumObstacles(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    Deque<int[]> deque = new ArrayDeque<>();
    int[][] distance = new int[m][n];
    for (int[] row : distance)
      Arrays.fill(row, Integer.MAX_VALUE);

    deque.addFirst(new int[] { 0, 0 });
    distance[0][0] = 0;

    while (!deque.isEmpty()) {
      int[] curr = deque.pollFirst();
      int x = curr[0], y = curr[1];

      for (int[] dir : directions) {
        int nx = x + dir[0], ny = y + dir[1];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
          int newDist = distance[x][y] + grid[nx][ny];
          if (newDist < distance[nx][ny]) {
            distance[nx][ny] = newDist;
            if (grid[nx][ny] == 0) {
              deque.addFirst(new int[] { nx, ny });
            } else {
              deque.addLast(new int[] { nx, ny });
            }
          }
        }
      }
    }

    return distance[m - 1][n - 1];
  }
}
