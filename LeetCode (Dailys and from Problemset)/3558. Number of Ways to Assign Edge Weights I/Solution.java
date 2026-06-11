import java.util.ArrayList;
import java.util.List;

class Solution {

  static final long MOD = 1_000_000_007L;

  public int assignEdgeWeights(int[][] edges) {
    int n = edges.length + 1;

    List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] e : edges) {
      int u = e[0];
      int v = e[1];

      graph[u].add(v);
      graph[v].add(u);
    }

    int depth = dfs(1, -1, graph);

    // answer = 2^(depth - 1)
    return (int) modPow(2, depth - 1);
  }

  private int dfs(int node, int parent, List<Integer>[] graph) {
    int maxDepth = 0;

    for (int nei : graph[node]) {
      if (nei == parent)
        continue;

      maxDepth = Math.max(maxDepth, 1 + dfs(nei, node, graph));
    }

    return maxDepth;
  }

  private long modPow(long base, long exp) {
    long res = 1;

    while (exp > 0) {
      if ((exp & 1) == 1) {
        res = (res * base) % MOD;
      }

      base = (base * base) % MOD;
      exp >>= 1;
    }

    return res;
  }
}