import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

  final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public int minimumTime(int[][] grid) {
    int r = grid.length, c = grid[0].length;
    if (grid[0][1] > 1 && grid[1][0] > 1)
      return -1;

    int[][] dp = new int[r][c];
    for (int[] arr : dp)
      Arrays.fill(arr, -1);
    dp[0][0] = 0;

    Queue<int[]> bfs = new LinkedList<>();
    bfs.add(new int[] { 0, 0 });
    while (!bfs.isEmpty()) {
      int top[] = bfs.remove();
      for (int dir[] : dirs) {
        int nr = top[0] + dir[0], nc = top[1] + dir[1];
        if (nr < 0 || nc < 0 || nr == r || nc == c)
          continue;
        int next = dp[top[0]][top[1]] + 1;
        if (next < grid[nr][nc]) {
          int diff = grid[nr][nc] - next;
          if (diff % 2 != 0)
            diff++;
          next += diff;
        }

        if (next >= grid[nr][nc] && (dp[nr][nc] == -1 || next < dp[nr][nc])) {
          dp[nr][nc] = next;
          bfs.add(new int[] { nr, nc });
        }
      }
    }
    return dp[r - 1][c - 1];
  }
}