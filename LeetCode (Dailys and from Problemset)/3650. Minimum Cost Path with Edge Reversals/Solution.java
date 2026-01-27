import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
  class Pair {
    int node;
    int dist;

    Pair(int node, int dist) {
      this.node = node;
      this.dist = dist;
    }
  }

  public int minCost(int n, int[][] edges) {
    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < edges.length; i++) {
      adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
      adj.get(edges[i][1]).add(new Pair(edges[i][0], 2 * edges[i][2]));

    }

    int[] mat = new int[n];
    Arrays.fill(mat, Integer.MAX_VALUE);
    mat[0] = 0;

    Queue<Pair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
    pq.add(new Pair(0, 0));
    while (pq.size() > 0) {
      Pair p = pq.remove();
      int dist = p.dist;
      int node = p.node;
      for (Pair t : adj.get(node)) {
        int ele = t.node;

        int total = dist + t.dist;

        if (mat[ele] > total) {
          mat[ele] = total;
          pq.add(new Pair(ele, total));
        }
      }

    }
    if (mat[n - 1] == Integer.MAX_VALUE)
      return -1;

    return mat[n - 1];

  }
}