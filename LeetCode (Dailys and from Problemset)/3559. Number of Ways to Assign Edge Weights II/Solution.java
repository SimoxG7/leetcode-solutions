import java.util.ArrayList;
import java.util.List;

class Solution {

  static final int MOD = 1_000_000_007;
  static final int LOG = 18;

  List<Integer>[] graph;
  int[][] parent;
  int[] depth;

  public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

    int n = edges.length + 1;

    graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];

      graph[u].add(v);
      graph[v].add(u);
    }

    parent = new int[LOG][n + 1];
    depth = new int[n + 1];

    dfs(1, 0);

    for (int j = 1; j < LOG; j++) {
      for (int node = 1; node <= n; node++) {
        parent[j][node] = parent[j - 1][parent[j - 1][node]];
      }
    }

    int[] ans = new int[queries.length];

    for (int i = 0; i < queries.length; i++) {

      int u = queries[i][0];
      int v = queries[i][1];

      int lca = getLCA(u, v);

      int dist = depth[u]
          + depth[v]
          - 2 * depth[lca];

      ans[i] = (dist == 0)
          ? 0
          : (int) power(2, dist - 1);
    }

    return ans;
  }

  private void dfs(int node, int par) {

    parent[0][node] = par;

    for (int nei : graph[node]) {

      if (nei == par)
        continue;

      depth[nei] = depth[node] + 1;

      dfs(nei, node);
    }
  }

  private int getLCA(int u, int v) {

    if (depth[u] < depth[v]) {
      int temp = u;
      u = v;
      v = temp;
    }

    int diff = depth[u] - depth[v];

    for (int j = 0; j < LOG; j++) {
      if (((diff >> j) & 1) == 1) {
        u = parent[j][u];
      }
    }

    if (u == v)
      return u;

    for (int j = LOG - 1; j >= 0; j--) {

      if (parent[j][u] != parent[j][v]) {
        u = parent[j][u];
        v = parent[j][v];
      }
    }

    return parent[0][u];
  }

  private long power(long a, long b) {

    if (b == 0)
      return 1;

    long half = power(a, b / 2);

    long res = (half * half) % MOD;

    if ((b & 1) == 1) {
      res = (res * a) % MOD;
    }

    return res;
  }
}