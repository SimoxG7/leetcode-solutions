import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
  public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
    int[] rowOrder = topologicalSort(k, rowConditions);
    int[] colOrder = topologicalSort(k, colConditions);

    if (rowOrder == null || colOrder == null) {
      return new int[0][0];
    }

    int[][] matrix = new int[k][k];

    int[] rowPosition = new int[k + 1];
    int[] colPosition = new int[k + 1];

    for (int i = 0; i < k; i++) {
      rowPosition[rowOrder[i]] = i;
      colPosition[colOrder[i]] = i;
    }

    for (int i = 1; i <= k; i++) {
      matrix[rowPosition[i]][colPosition[i]] = i;
    }

    return matrix;
  }

  private int[] topologicalSort(int k, int[][] conditions) {
    List<Integer>[] graph = new List[k + 1];
    int[] inDegree = new int[k + 1];

    for (int i = 1; i <= k; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] condition : conditions) {
      int u = condition[0];
      int v = condition[1];
      graph[u].add(v);
      inDegree[v]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= k; i++) {
      if (inDegree[i] == 0) {
        queue.offer(i);
      }
    }

    int[] order = new int[k];
    int index = 0;

    while (!queue.isEmpty()) {
      int node = queue.poll();
      order[index++] = node;

      for (int neighbor : graph[node]) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    return index == k ? order : null;
  }
}