import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];

    for (int i = 0; i < n; i++) {
      if (colors[i] != 0) {
        continue;
      }

      Queue<Integer> q = new LinkedList<>();
      q.offer(i);
      colors[i] = 1;

      while (!q.isEmpty()) {
        int curr = q.poll();

        for (int neighbor : graph[curr]) {
          if (colors[neighbor] == 0) {
            colors[neighbor] = -colors[curr];
            q.offer(neighbor);
          } else if (colors[neighbor] == colors[curr]) {
            return false;
          }
        }
      }
    }

    return true;
  }
}