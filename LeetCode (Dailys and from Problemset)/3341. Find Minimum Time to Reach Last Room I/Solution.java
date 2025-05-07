import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  public int minTimeToReach(int[][] moveTime) {
    int n = moveTime.length; 
    int m = moveTime[0].length; 

    Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.add(new int[] { 0, 0, 0 });

    int[][] time = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++)
        time[i][j] = Integer.MAX_VALUE;
    }

    int[] dirx = new int[] { 0, 1, 0, -1 };
    int[] diry = new int[] { 1, 0, -1, 0 };

    while (!pq.isEmpty()) {

      int[] a = pq.poll();

      int t = a[0];
      int x = a[1];
      int y = a[2];

      if (x == n - 1 && y == m - 1)
        return t;

      for (int i = 0; i < 4; i++) {

        int xx = x + dirx[i];
        int yy = y + diry[i];

        if (xx >= 0 && xx < n && yy >= 0 && yy < m) {
          int wt = moveTime[xx][yy];
          int tt = Math.max(t + 1, wt + 1);
          if (time[xx][yy] > tt) {
            time[xx][yy] = tt;
            pq.add(new int[] { tt, xx, yy });
          }
        }
      }
    }
    return -1;
  }
}