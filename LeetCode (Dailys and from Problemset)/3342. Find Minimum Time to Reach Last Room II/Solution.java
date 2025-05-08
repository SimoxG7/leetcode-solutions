import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int minTimeToReach(int[][] moveTime) {
    int n = moveTime.length;
    int m = moveTime[0].length;
    int INF = Integer.MAX_VALUE;
    int[][] dp = new int[n][m];
    for (int[] row : dp) {
      Arrays.fill(row, INF);
    }
    Queue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
    heap.add(new int[] { 0, 0, 0 });
    moveTime[0][0] = 0;
    int[][] ways = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    while (!heap.isEmpty()) {
      int[] cur = heap.poll();
      int time = cur[0];
      int row = cur[1];
      int col = cur[2];
      if (time > dp[row][col]) {
        continue;
      }
      if (row == n - 1 && col == m - 1) {
        return time;
      }
      dp[row][col] = time;
      for (int[] move : ways) {
        int nextRow = row + move[0];
        int nextCol = col + move[1];
        if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && dp[nextRow][nextCol] == INF) {
          int cost = (row + col) % 2 + 1;
          int count = Math.max(moveTime[nextRow][nextCol], time);
          int nextTime = count + cost;
          if (nextTime < dp[nextRow][nextCol]) {
            dp[nextRow][nextCol] = nextTime;
            heap.add(new int[] { nextTime, nextRow, nextCol });
          }

        }
      }
    }
    return -1;
  }
}