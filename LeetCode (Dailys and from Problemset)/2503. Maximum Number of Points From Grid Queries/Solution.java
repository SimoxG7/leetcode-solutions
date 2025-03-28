import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  private final int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

  public int[] maxPoints(int[][] grid, int[] queries) {
    int n = grid.length, m = grid[0].length, k = queries.length;
    int[] res = new int[k];
    List<int[]> qi = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      qi.add(new int[] { queries[i], i });
    }
    Collections.sort(qi, (a, b) -> Integer.compare(a[0], b[0]));
    Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[] { grid[0][0], 0, 0 });
    boolean[][] visited = new boolean[n][m];
    visited[0][0] = true;
    int count = 0;
    for (int[] q : qi) {
      int limit = q[0], idx = q[1];

      while (!pq.isEmpty() && pq.peek()[0] < limit) {
        int[] cur = pq.poll();
        int row = cur[1], col = cur[2];
        count++;

        for (int[] dir : dirs) {
          int dr = row + dir[0], dc = col + dir[1];
          if (dr >= 0 && dr < n && dc >= 0 && dc < m && !visited[dr][dc]) {
            visited[dr][dc] = true;
            pq.offer(new int[] { grid[dr][dc], dr, dc });
          }
        }
      }

      res[idx] = count;
    }

    return res;
  }
}